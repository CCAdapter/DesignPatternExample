package observer.ex1_ex2;

public class Ex2Observer implements Observer {
    @Override
    public void update(NumberGenerator generator) {
        System.out.println("Ex2Observer: [" + generator.getNumber() + "]");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
