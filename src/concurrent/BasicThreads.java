package concurrent;

/**
 * Created by yangyang on 2017/4/16 14:32.
 */
public class BasicThreads {

    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff! ");
    }
}
