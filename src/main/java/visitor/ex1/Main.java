package visitor.ex1;

import visitor.Directory;
import visitor.File;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        try {
            Directory rootDir = new Directory("root");
            Directory binDir = new Directory("bin");
            Directory tmpDir = new Directory("tmp");
            Directory usrDir = new Directory("usr");
            rootDir.add(binDir);
            rootDir.add(tmpDir);
            rootDir.add(usrDir);
            binDir.add(new File("vi", 10000));
            binDir.add(new File("latex", 20000));
            Directory yuki = new Directory("yuki");
            Directory hanako = new Directory("hanako");
            Directory tomura = new Directory("tomura");
            usrDir.add(yuki);
            usrDir.add(hanako);
            usrDir.add(tomura);
            yuki.add(new File("diary.html", 100));
            yuki.add(new File("Composite.java", 200));
            hanako.add(new File("memo.tex", 300));
            hanako.add(new File("index.html", 350));
            tomura.add(new File("game.doc", 400));
            tomura.add(new File("junk.mail", 500));

            FileFindVisitor ffv = new FileFindVisitor(".html");
            rootDir.accept(ffv);

            System.out.println("HTML files are:");
            Iterator<File> it = ffv.getFoundFiles();
            while (it.hasNext()) {
                File file = it.next();
                System.out.println(file.toString());
            }

            FileFindVisitorWithOneClass ffvwoc = new FileFindVisitorWithOneClass(".html");
            rootDir.accept(ffvwoc);

            System.out.println("(WithOneClass) HTML files are:");
            Iterator<File> itwoc = ffvwoc.getFoundFiles();
            while (itwoc.hasNext()) {
                File file = itwoc.next();
                System.out.println(file.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
