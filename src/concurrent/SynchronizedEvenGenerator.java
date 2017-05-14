package concurrent;

/**
 * Created by yangyang on 2017/5/2 22:51.
 */
public class SynchronizedEvenGenerator extends IntGenerator{
    private int currentEvenValue = 0;
    @Override
    public synchronized int next() {
        currentEvenValue++;
        Thread.yield();
        currentEvenValue++;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}
