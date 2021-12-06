package visitor.ex1;

import visitor.Directory;
import visitor.Entry;
import visitor.File;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileFindVisitorWithOneClass extends Visitor {
    String fileType;

    List<File> foundFiles;

    public FileFindVisitorWithOneClass(String target) {
        this.fileType = target;
        foundFiles = new ArrayList<>();
    }

    // 用一个方法实现消息分发，双重分发等价实现方法
    public void visit(Entry entry) {
        if (entry instanceof File) {
            this.visit((File) entry);
        } else if (entry instanceof Directory){
            this.visit((Directory) entry);
        }
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
        while (it.hasNext()) {
            Entry next = it.next();
            // 不报错了
            this.visit(next);
        }
    }

    public Iterator<File> getFoundFiles() {
        return foundFiles.iterator();
    }
}
