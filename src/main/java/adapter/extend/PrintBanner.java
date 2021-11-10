package adapter.extend;

/**
 * @author Lyu Liang
 * @since 2021-11-11 00:28
 */
public class PrintBanner extends Banner implements Print {
    public PrintBanner(String string) {
        super(string);
    }

    @Override
    public void printWeak() {
        super.showWithParam();
    }

    @Override
    public void printStrong() {
        super.showWithAster();
    }
}
