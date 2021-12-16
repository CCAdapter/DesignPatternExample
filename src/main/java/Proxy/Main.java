package Proxy;

public class Main {
    public static void main(String[] args) {
        Printable p = new PrinterProxy("Alice");
        System.out.println("现在的名字是 " + p.getPrintName() + "。");
        p.setPrinterName("Bob");
        System.out.println("现在的名字是 " + p.getPrintName() + "。");
        p.print("Hello, world.");
    }
}
