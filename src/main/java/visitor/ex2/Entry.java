package visitor.ex2;

import visitor.ex2.Element;
import visitor.ex2.FileTreatmentException;

import java.util.Iterator;

public abstract class Entry implements Element {
    protected abstract String getName();

    protected abstract int getSize();

    public Entry add(Entry entry) throws FileTreatmentException {
        throw new FileTreatmentException();
    }

    public Iterator<Entry> iterator() throws FileTreatmentException {
        throw new FileTreatmentException();
    }

    public String toString() {
        return getName() + "(" + getSize() + ")";
    }
}
