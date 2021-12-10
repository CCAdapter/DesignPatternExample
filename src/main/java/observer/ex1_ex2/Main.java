package observer.ex1_ex2;

public class Main {
    public static void main(String[] args) {
        NumberGenerator generator = new IncrementalNumberGenerator(10, 50, 5);
        DigitObserver observer1 = new DigitObserver();
        GraphObserver observer2 = new GraphObserver();
        Ex2Observer observer3 = new Ex2Observer();
        generator.addObserver(observer1);
        generator.addObserver(observer2);
        generator.addObserver(observer3);
        generator.execute();
    }
}
