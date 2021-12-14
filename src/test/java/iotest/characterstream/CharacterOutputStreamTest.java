package iotest.characterstream;

import java.io.*;

public class CharacterOutputStreamTest {
    public static void main(String[] args) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("d.txt"));
        outputStreamWriter.write(97);
        outputStreamWriter.write('b');

        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        bufferedWriter.newLine();
        bufferedWriter.write("你好！");

        bufferedWriter.close();
        outputStreamWriter.close();
    }
}
