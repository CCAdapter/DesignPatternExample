package visitor.ex2;

import visitor.ex2.Directory;
import visitor.ex2.Entry;
import visitor.ex2.File;
import visitor.ex2.Visitor;

import java.util.Iterator;

public class SizeVisitor extends Visitor {
    private int size;

    @Override
    public void visit(File file) {
        size += file.getSize();
    }

    @Override
    public void visit(Directory directory) {
        Iterator<Entry> it = directory.iterator();
        while (it.hasNext()) {
            Entry entry = it.next();
            entry.accept(this);
        }
    }

    public int getSize() {
        return size;
    }
}
