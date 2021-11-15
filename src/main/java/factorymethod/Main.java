package factorymethod;

import factorymethod.framework.Factory;
import factorymethod.framework.Product;
import factorymethod.idcard.IDCardFactory;

public class Main {
    public static void main(String[] args) {
        Factory idCardFactory = new IDCardFactory();
        Product card1 = idCardFactory.create("小明");
        Product card2 = idCardFactory.create("小红");
        card1.use();
        card2.use();
    }
}
