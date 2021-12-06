package visitor.ex3;

import java.util.ArrayList;
import java.util.Iterator;

public class ElementArrayList extends ArrayList<Element> implements Element {

    @Override
    public void accept(Visitor v) {
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            Element element = it.next();
            element.accept(v);
        }
    }
}
