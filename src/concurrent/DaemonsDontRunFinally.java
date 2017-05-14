package concurrent;

import java.util.concurrent.TimeUnit;

/**
 * Created by yangyang on 2017/4/29 11:48.
 */
class ADaemon implements Runnable{
    @Override
    public void run() {
        try {
            System.out.println("Starting ADaemon");
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e) {
            System.out.println("Existing via InterruptedException");
        }finally {
            System.out.println("This should always run? ");
        }
    }
}

public class DaemonsDontRunFinally {
    public static void main(String[] args) throws Exception{
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();
    }
}
