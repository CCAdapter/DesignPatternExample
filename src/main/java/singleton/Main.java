package singleton;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start.");
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
        if (obj1 == obj2) {
            System.out.println("生成的实例相同");
        } else {
            System.out.println("生成的实例不同");
        }
        System.out.println("End.");
    }
}
