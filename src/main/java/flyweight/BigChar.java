package flyweight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class BigChar {
    // 字符名称
    private char charName;
    // 大型字符对应的字符串（由‘#’、‘。’、‘\n’组成）
    private String fontData;

    public BigChar(char charName) {
        this.charName = charName;
        BufferedReader reader = null;
        try {
            try {
                String path = BigChar.class.getClassLoader().getResource("flyweightfile").getPath() + "/big" + charName + ".txt";
                reader = new BufferedReader(new FileReader(path));
                String line;
                StringBuilder sb = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                    sb.append("\n");
                }
                this.fontData = sb.toString();
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void print() {
        System.out.println(fontData);
    }
}
