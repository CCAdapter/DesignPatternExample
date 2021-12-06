package visitor.ex1;

import visitor.Directory;
import visitor.Entry;
import visitor.File;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileFindVisitor extends Visitor {
    String fileType;

    List<File> foundFiles;

    public FileFindVisitor(String target) {
        this.fileType = target;
        foundFiles = new ArrayList<>();
    }

    @Override
    public void visit(File file) {
        String fileName = file.getName();
        if (fileName != null && fileName.endsWith(".html")) {
            foundFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        Iterator<Entry> it = directory.iterator();

        // 报错
//        while (it.hasNext()) {
//            Entry next = it.next();
//            this.visit(next);
//        }

        // 正确
        while (it.hasNext()) {
            Entry next = it.next();
            next.accept(this);
        }
    }

    public Iterator<File> getFoundFiles() {
        return foundFiles.iterator();
    }
}
