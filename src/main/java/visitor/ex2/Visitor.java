package visitor.ex2;

import visitor.ex2.Directory;
import visitor.ex2.File;

public abstract class Visitor {
    public abstract void visit(File file);

    public abstract void visit(Directory directory);
}
