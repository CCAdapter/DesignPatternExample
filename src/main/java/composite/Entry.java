package composite;

public abstract class Entry {
    protected Entry parent;

    protected abstract String getName();

    protected abstract int getSize();

    /**
     * 获取文件/文件夹的路径
     * @return 文件/文件夹的路径字符串
     */
    public String getPath() {
        return getPath("");
    }

    protected String getPath(String suffix) {
        suffix = suffix == null || "".equals(suffix) ? "" : "/" + suffix;
        if (parent == null) {
            return "/" + getName() + suffix;
        }
        return parent.getPath(getName() + suffix);
    }

    public Entry add(Entry entry) throws FileTreatmentException {
        throw new FileTreatmentException();
    }

    public void printList() {
        printList("");
    }

    protected abstract void printList(String prefix);

    public String toString() {
        return getName() + "(" + getSize() + ")";
    }
}
