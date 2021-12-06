package chainofresponsibility;

/**
 * @author Lyu Liang
 * @since 2021-12-07 00:26
 */
public class NoSupport extends Support {
    public NoSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return false;
    }
}
