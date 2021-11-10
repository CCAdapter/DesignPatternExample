package iterator;

public interface Iterator {
    // 确认接下来是否可以调用next方法
    public abstract boolean hasNext();

    // 返回当前元素并指向下一个元素
    public abstract Object next();
}
