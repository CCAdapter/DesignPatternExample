package visitor.ex2;

import visitor.ex2.Visitor;

public interface Element {
    public abstract void accept(Visitor v);
}
