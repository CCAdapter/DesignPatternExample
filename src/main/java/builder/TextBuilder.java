package builder;

public class TextBuilder extends Builder {
    private StringBuilder sb = new StringBuilder();

    @Override
    public void makeTitle(String title) {
        sb.append("=====================================\n");
        sb.append("【" + title + "】\n");
    }

    @Override
    public void makeString(String str) {
        sb.append('#' + str + "\n");
    }

    @Override
    public void makeItems(String[] items) {
        for (String item : items) {
            sb.append("  ." + item + "\n");
        }
    }

    @Override
    public void close() {
        sb.append("=====================================\n");
    }

    public String getResult() {
        return sb.toString();
    }
}
