import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        for (int k = 0; k < 10; k++) {
//            int i = 1, j = 5;
//            double random = Math.random();
//            System.out.println(random);
//            System.out.println((int) (random * (j - i + 1) + i));
            System.out.println(new Random().nextInt(5));
        }
    }
}
