package visitor.ex3;

import visitor.ex3.Directory;
import visitor.ex3.File;

public abstract class Visitor {
    public abstract void visit(File file);

    public abstract void visit(Directory directory);
}
