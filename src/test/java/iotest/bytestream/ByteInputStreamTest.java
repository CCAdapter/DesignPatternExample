package iotest.bytestream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ByteInputStreamTest {
    // 从流中一次读取的字节数
    public static final int BATCH_SIZE = 64;

    public static String ByteInputSteamTest(String path) throws IOException {
        long start = System.currentTimeMillis();
        FileInputStream fileInputStream = new FileInputStream(path);
        byte[] buff = new byte[BATCH_SIZE];
        int len;
        while ((len = fileInputStream.read(buff)) != -1) {
            new String(buff, 0, len);
        }
        fileInputStream.close();
        long finish = System.currentTimeMillis();
        return "cost " + (finish - start) + "ms";
    }

    public static String BuffedByteInputSteamTest(String path) throws IOException {
        long start = System.currentTimeMillis();
        FileInputStream fileInputStream = new FileInputStream(path);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        byte[] buff = new byte[BATCH_SIZE];
        int len;
        while ((len = bufferedInputStream.read(buff)) != -1) {
            new String(buff, 0, len);
        }
        bufferedInputStream.close();
        fileInputStream.close();
        long finish = System.currentTimeMillis();
        return "cost " + (finish - start) + "ms";
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        String fileName = "TheConfessions.txt";
        String path = ByteInputStreamTest.class.getClassLoader().getResource(fileName).getPath();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String s = ByteInputSteamTest(path);
            String s1 = BuffedByteInputSteamTest(path);
            list.add(s + "-" + s1);
        }
        System.out.println(list);
    }
}
