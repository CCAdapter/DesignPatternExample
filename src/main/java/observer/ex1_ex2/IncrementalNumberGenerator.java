package observer.ex1_ex2;

public class IncrementalNumberGenerator extends NumberGenerator {
    int curValue;
    int finalValue;
    int step;

    public IncrementalNumberGenerator(int initialValue, int finalValue, int step) {
        this.curValue = initialValue;
        this.finalValue = finalValue;
        this.step = step;
    }

    @Override
    public int getNumber() {
        return curValue;
    }

    @Override
    public void execute() {
        while (curValue < finalValue) {
            notifyObservers();
            if (curValue + step < finalValue) {
                curValue += step;
            } else {
                break;
            }
        }
    }
}
