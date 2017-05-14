package concurrent;

/**
 * Created by yangyang on 2017/4/16 14:19.
 */
public class LiftOff implements Runnable{
    protected int countDown = 10; // default
    private static int taskCount = 0;
    private final int id = taskCount++;
    public LiftOff() {}
    public LiftOff(int countDown) {
        this.countDown = countDown;
    }
    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff! ") + "), ";
    }
    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.print(status());
            Thread.yield(); // only a suggestion, may be ignored, can not rely on it
        }
    }
}
