package iotest.bytestream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteOutputStreamTest {
    public static void main(String[] args) throws IOException {
        //  输出内容
        byte[] bytes = "lei hou a! 你好啊！".getBytes();

        // FileOutputStream
        FileOutputStream fileOutputStream = new FileOutputStream("b.txt");
        fileOutputStream.write(bytes);
        fileOutputStream.close();

        // BufferedOutputStream
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("c.txt"));
        bufferedOutputStream.write(bytes);
        bufferedOutputStream.close();
    }
}
