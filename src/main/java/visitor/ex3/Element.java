package visitor.ex3;

import visitor.ex3.Visitor;

public interface Element {
    public abstract void accept(Visitor v);
}
