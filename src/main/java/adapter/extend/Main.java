package adapter.extend;

import java.util.ArrayList;

/**
 * @author Lyu Liang
 * @since 2021-11-11 00:28
 */
public class Main {
    public static void main(String[] args) {
        Print print = new PrintBanner("adapter_extend");
        print.printStrong();
        print.printWeak();
    }
}
