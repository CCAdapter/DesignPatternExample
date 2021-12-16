package Proxy;

public interface Printable {
    public abstract void setPrinterName(String name);

    public abstract String getPrintName();

    public abstract void print(String string);
}
