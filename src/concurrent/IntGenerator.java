package concurrent;

/**
 * Created by yangyang on 2017/4/29 16:06.
 */
public abstract class IntGenerator {
    private volatile boolean cancel = false;
    public abstract int next();
    public void cancel() {
        cancel = true;
    }
    public boolean isCancel() {
        return cancel;
    }
}
