package Proxy.ex1;

public class Main {
    public static void main(String[] args) {
        Printable p = new PrinterProxy("Alice", Printer.class.getName());
        System.out.println("现在的名字是 " + p.getPrintName() + "。");
        p.setPrinterName("Bob");
        System.out.println("现在的名字是 " + p.getPrintName() + "。");
        p.print("Hello, world.");
    }
}
