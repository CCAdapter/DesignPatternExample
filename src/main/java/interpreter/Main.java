package interpreter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader = null;
            try {
                String path = Main.class.getClassLoader().getResource("program.txt").getPath();
                reader = new BufferedReader(new FileReader(path));
                String text =  null;
                while ((text = reader.readLine()) != null) {
                    System.out.println("text = \"" + text + "\"");
                    Node node = new ProgramNode();
                    node.parse(new Context(text));
                    System.out.println("node = " + node);
                }
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
