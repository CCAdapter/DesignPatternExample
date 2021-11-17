package abstractfactory.listfactory;

import abstractfactory.factory.Item;
import abstractfactory.factory.Tray;

import java.util.Iterator;

public class ListTray extends Tray {
    public ListTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<li>\n").append(caption + "\n").append("<ul>\n");
        Iterator<Item> it = tray.iterator();
        while (it.hasNext()) {
            Item item = it.next();
            sb.append(item.makeHTML());
        }
        sb.append("</ul>\n").append("</li>\n");
        return sb.toString();
    }
}
