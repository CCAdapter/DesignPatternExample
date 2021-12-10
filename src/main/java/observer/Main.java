package observer;

public class Main {
    public static void main(String[] args) {
        RandomNumberGenerator generator = new RandomNumberGenerator();
        DigitObserver observer1 = new DigitObserver();
        GraphObserver observer2 = new GraphObserver();
        generator.addObserver(observer1);
        generator.addObserver(observer2);
        generator.execute();
    }
}
