package abstractfactory.tablefactory;

import abstractfactory.factory.Item;
import abstractfactory.factory.Tray;

import java.util.Iterator;

public class TableTray extends Tray {
    public TableTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<td>");
        sb.append("<table width=\"100%\" border=\"1\"><tr>");
        sb.append("<td bgcolor=\"#cccccc\" align=\"center\" colspan=\"" + tray.size() + "\"><b>" + caption + "</b></td>");
        sb.append("</tr>\n").append("<tr>\n");
        Iterator<Item> it = tray.iterator();
        while (it.hasNext()) {
            Item item = it.next();
            sb.append(item.makeHTML());
        }
        sb.append("</tr></table>").append("</td>");
        return sb.toString();
    }
}
