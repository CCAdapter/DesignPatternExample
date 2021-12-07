package facade.pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PageMaker {
    private PageMaker() {
    }

    public static void makeWelcomePage(String mailAddr, String filename) {
        try {
            Properties mailProp = Database.getProperties("maildata");
            String username = mailProp.getProperty(mailAddr);
            HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
            writer.title("Welcome to " + username + "'s page!");
            writer.paragraph(username + " 欢迎来到 " + username + " 的主页");
            writer.paragraph(" 等着你的邮件！");
            writer.mailto(mailAddr, username);
            writer.close();
            System.out.println(filename + " is created for " + mailAddr
                    + " (" + username + ")");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void makeLinkPage(String filename) {
        Properties mailProp = Database.getProperties("maildata");
        try {
            HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
            writer.title("Link page");
            for (String key : mailProp.stringPropertyNames()) {
                String value = mailProp.getProperty(key);
                writer.mailto(key, value);
            }
            writer.close();
            System.out.println(filename + " is created");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
