package adapter.entrust;

import adapter.extend.Banner;

/**
 * @author Lyu Liang
 * @since 2021-11-11 00:28
 */
public class PrintBanner extends Print {
    Banner banner;

    public PrintBanner(String string) {
        banner = new Banner(string);
    }

    @Override
    public void printWeak() {
        banner.showWithParam();
    }

    @Override
    public void printStrong() {
        banner.showWithAster();
    }
}
