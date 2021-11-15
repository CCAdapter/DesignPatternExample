package templatemethod;

public class Main {
    public static void main(String[] args) {
        AbstractDisplay d1 = new CharDisplay('H');
        d1.display();

        AbstractDisplay d2 = new StringDisplay("Hello, world.");
        d2.display();

        AbstractDisplay d3 = new StringDisplay("你好，世界。");
        d3.display();

        System.out.println("你好，世界。".length());
        System.out.println("你好，世界。".getBytes().length);
    }
}
