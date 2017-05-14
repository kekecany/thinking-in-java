package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by yangyang on 2017/4/16 17:15.
 */
public class DaemonFromFactory implements Runnable {

    public void run() {
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for (int i = 0; i < 10 ; i++) {
            exec.execute(new DaemonFromFactory());
        }
        exec.shutdown();
        System.out.println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(500);
    }
}
