package adapter.ex2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class FileProperties implements FileIO {
    String resourcePath = FileProperties.class.getClassLoader().getResource("adapterfile").getPath();
    Properties properties = new Properties();

    @Override
    public void readFromFile(String fileName) throws IOException {
        String inputPath = resourcePath + "/" + fileName;
        System.out.println(inputPath);
        properties.load(new FileInputStream(inputPath));
    }

    @Override
    public void writeToFile(String fileName) throws IOException {
        String outputPath = resourcePath + "/" + fileName;
        String header = "written by FileProperties";
        properties.store(new FileOutputStream(outputPath), header);
    }

    @Override
    public void setValue(String key, String value) {
        properties.setProperty(key, value);
    }

    @Override
    public void getValue(String key) {
        properties.getProperty(key);
    }
}
