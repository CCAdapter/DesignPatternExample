import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolDynamicChangeTest {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = ThreadPoolBuilder();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 500; i++) {
            try {
                threadPool.submit(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            } catch (RejectedExecutionException e) {
                System.out.println(e);
            }
        }
        Thread statusThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                threadPoolStatus(threadPool, "线程池状态统计1");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    System.out.println(e);
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println(Thread.currentThread().getName() + " 被中断");
            countDownLatch.countDown();
        }, "更改前的Thread");
        statusThread.start();
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        statusThread.interrupt();

        // 更改线程池配置
        threadPool.setMaximumPoolSize(100);
        threadPool.setCorePoolSize(50);

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (!statusThread.isAlive()) {
            Thread newStatusThread = new Thread(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    threadPoolStatus(threadPool, "线程池状态统计2");
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "更改后的Thread");
            newStatusThread.start();
        }
    }

    private static void threadPoolStatus(ThreadPoolExecutor threadPool, String name) {
        BlockingQueue<Runnable> queue = threadPool.getQueue();
        String format = MessageFormat.format(
                "{9}-{0}-{1}：" +
                        "核心线程数：{2}，" +
                        "最大线程数：{3}，" +
                        "活动线程数：{4}，" +
                        "任务完成数：{5}，" +
                        "队列大小：{6}，" +
                        "当前排队线程数：{7}，" +
                        "队列剩余大小：{8}，" +
                        "队列使用率：{10}，",
                Thread.currentThread().getName(),
                name,
                threadPool.getCorePoolSize(),
                threadPool.getMaximumPoolSize(),
                threadPool.getActiveCount(),
                threadPool.getCompletedTaskCount(),
                (queue.size() + queue.remainingCapacity()),
                queue.size(),
                queue.remainingCapacity(),
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()),
                String.format("%1.2f%%", queue.size() / (1.0 * (queue.size() + queue.remainingCapacity())) * 100)
        );
        System.out.println(format);
    }

    private static ThreadPoolExecutor ThreadPoolBuilder() {
        return new ThreadPoolExecutor(2, 5, 0, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(500));
    }
}
