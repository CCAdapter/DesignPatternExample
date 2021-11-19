package singleton;

public class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton() {
        System.out.println("生成了一个实例");
    }

    public static Singleton getInstance() {
        return instance;
    }
}
