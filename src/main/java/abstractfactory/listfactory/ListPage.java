package abstractfactory.listfactory;

import abstractfactory.factory.Item;
import abstractfactory.factory.Page;

import java.util.Iterator;

public class ListPage extends Page {
    public ListPage(String title, String author) {
        super(title, author);
    }

    @Override
    public String makeHTML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><head><title>").append(title).append("</title></head>\n");
        sb.append("<body>\n").append("<h1>").append(title).append("</h1>\n");
        sb.append("<ul>\n");
        Iterator<Item> it = content.iterator();
        while (it.hasNext()) {
            Item item = it.next();
            sb.append(item.makeHTML());
        }
        sb.append("</ul>\n").append("<hr><address>" + author + "</address>");
        sb.append("</body></html>\n");
        return sb.toString();
    }
}

