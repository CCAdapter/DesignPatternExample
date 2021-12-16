package flyweight.ex1ex2;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Main digits");
            System.out.println("Example: java Main 1212123");
            System.exit(0);
        }

        System.out.println("-------- Shared -------");
        Runtime.getRuntime().gc();
        BigString bsByShared = new BigString(args[0], true);
        long used1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("使用内存 = " + used1);

        System.out.println("-------- No Shared -------");

        Runtime.getRuntime().gc();
        BigString bsByNoShared = new BigString(args[0], true);
        long used2 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("使用内存 = " + used2);

    }
}
