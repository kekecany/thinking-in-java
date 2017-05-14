package concurrent;

/**
 * Created by yangyang on 2017/4/29 16:16.
 */
public class EvenGenerator extends IntGenerator {
    private int currentValue = 0;
    @Override
    public int next() {
        currentValue++;
        currentValue++;
        return currentValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
