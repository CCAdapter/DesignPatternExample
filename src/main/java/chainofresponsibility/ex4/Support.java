package chainofresponsibility.ex4;

/**
 * @author Lyu Liang
 * @since 2021-12-07 00:26
 */
public abstract class Support {
    private String name;
    private Support next;

    public Support(String name) {
        this.name = name;
    }

    public Support setNext(Support next) {
        this.next = next;
        return next;
    }

    public final void support(Trouble trouble) {
        Support currentSupport = this;
        boolean resolved;
        while (!(resolved = currentSupport.resolve(trouble))) {
            if (currentSupport.next != null) {
                currentSupport = currentSupport.next;
            } else {
                break;
            }
        }
        if (resolved) {
            currentSupport.done(trouble);
        } else {
            currentSupport.fail(trouble);
        }
    }

    public String toString() {
        return "[" + name + "]";
    }

    protected abstract boolean resolve(Trouble trouble);

    protected void done(Trouble trouble) {
        System.out.println(trouble + " is resolved by " + this + ".");
    }

    protected void fail(Trouble trouble) {
        System.out.println(trouble + " cannot be resolved.");
    }
}
