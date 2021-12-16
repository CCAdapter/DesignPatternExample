package Proxy;

import java.util.concurrent.TimeUnit;

public class Printer implements Printable {
    private String name;

    public Printer() {
        heavyJob("正在生成 Printer 的实例");
    }

    public Printer(String name) {
        this.name = name;
        heavyJob("正在生成 Printer 的实例(" + name + ")");
    }

    @Override
    public void setPrinterName(String name) {
        this.name = name;
    }

    @Override
    public String getPrintName() {
        return name;
    }

    @Override
    public void print(String string) {
        System.out.println("===" + name + "===");
        System.out.println(string);
    }

    private void heavyJob(String msg) {
        System.out.println(msg);
        for (int i = 0; i < 5; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(".");
        }
        System.out.println("结束。");
    }
}
