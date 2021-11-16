package prototype;

import prototype.framework.Manage;
import prototype.framework.Product;

public class Main {
    public static void main(String[] args) {
        Manage manage = new Manage();
        UnderlinePen uPen = new UnderlinePen('_');
        MessageBox mBox = new MessageBox('*');
        MessageBox sBox = new MessageBox('/');
        manage.register("strong message", uPen);
        manage.register("warning box", mBox);
        manage.register("slash box", sBox);

        Product p1 = manage.create("strong message");
        p1.use("Hello, world.");
        Product p2 = manage.create("warning box");
        p2.use("Hello, world.");
        Product p3 = manage.create("slash box");
        p3.use("Hello, world.");
    }
}
