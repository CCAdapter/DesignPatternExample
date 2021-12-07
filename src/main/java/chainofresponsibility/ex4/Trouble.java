package chainofresponsibility.ex4;

/**
 * @author Lyu Liang
 * @since 2021-12-07 00:25
 */
public class Trouble {
    private int number;

    public Trouble(int number) {
        this.number =  number;
    }

    public int getNumber() {
        return number;
    }

    public String toString() {
        return "[Trouble " + number + "]";
    }
}
