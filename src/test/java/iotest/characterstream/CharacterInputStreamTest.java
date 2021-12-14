package iotest.characterstream;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.io.*;

public class CharacterInputStreamTest {
    private static int BATCH_SIZE = 1024;

    // InputStreamReader.read()
    public static String InputStreamReaderSingleTest(String path) throws IOException {
        long start = System.currentTimeMillis();
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(path));
        int ch;
        while ((ch = inputStreamReader.read()) != -1) {
            char c = (char) ch;
        }
        inputStreamReader.close();
        long finish = System.currentTimeMillis();
        return "cost " + (finish - start) + "ms";
    }

    // InputStreamReader.read(char[])
    public static String InputStreamReaderBatchTest(String path) throws IOException {
        long start = System.currentTimeMillis();
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(path));
        char[] batch = new char[BATCH_SIZE];
        while (inputStreamReader.read(batch) != -1) {
            new String(batch);
        }
        inputStreamReader.close();
        long finish = System.currentTimeMillis();
        return "cost " + (finish - start) + "ms";
    }

    // FileReader
    public static String FileReaderTest(String path) throws IOException {
        long start = System.currentTimeMillis();
        FileReader fileReader = new FileReader(path);
        char[] batch = new char[BATCH_SIZE];
        while (fileReader.read(batch) != -1) {
            new String(batch);
        }
        fileReader.close();
        long finish = System.currentTimeMillis();
        return "cost " + (finish - start) + "ms";
    }

    // BufferedReader(FileReader)
    public static String BufferedReaderTestWithFileReader(String path) throws IOException {
        long start = System.currentTimeMillis();
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        char[] batch = new char[BATCH_SIZE];
        while (bufferedReader.read(batch) != -1) {
            new String(batch);
        }
        bufferedReader.close();
        fileReader.close();
        long finish = System.currentTimeMillis();
        return "cost " + (finish - start) + "ms";
    }

    // BufferedReader(InputStreamReader)
    public static String BufferedReaderTestWithInputStreamReader(String path) throws IOException {
        long start = System.currentTimeMillis();
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(path));
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        char[] batch = new char[BATCH_SIZE];
        while (bufferedReader.read(batch) != -1) {
            new String(batch);
        }
        bufferedReader.close();
        inputStreamReader.close();
        long finish = System.currentTimeMillis();
        return "cost " + (finish - start) + "ms";
    }

    // BufferedReader(InputStreamReader).readLine()
    public static String BufferedReaderTestWithInputStreamReaderAndReadLine(String path) throws IOException {
        long start = System.currentTimeMillis();
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(path));
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            new String(line);
        }
        bufferedReader.close();
        inputStreamReader.close();
        long finish = System.currentTimeMillis();
        return "cost " + (finish - start) + "ms";
    }

    public static void main(String[] args) throws IOException {
        String fileName = "TheConfessions.txt";
        String path = CharacterInputStreamTest.class.getClassLoader().getResource(fileName).getPath();
        System.out.println("InputStreamReaderSingleTest: " + InputStreamReaderSingleTest(path));
        System.out.println("InputStreamReaderBatchTest: " + InputStreamReaderBatchTest(path));
        System.out.println("FileReaderTest: " + FileReaderTest(path));
        System.out.println("BufferedReaderTestWithFileReader: " + BufferedReaderTestWithFileReader(path));
        System.out.println("BufferedReaderTestWithInputStreamReader: " + BufferedReaderTestWithInputStreamReader(path));
        System.out.println("BufferedReaderTestWithInputStreamReaderAndReadLine: " + BufferedReaderTestWithInputStreamReaderAndReadLine(path));
    }
}
