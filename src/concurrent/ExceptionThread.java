package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yangyang on 2017/4/29 14:51.
 */
public class ExceptionThread implements Runnable {

    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        try {
            ExecutorService exec = Executors.newCachedThreadPool();
            exec.execute(new ExceptionThread());
            exec.shutdown();
        }catch (RuntimeException e) {
            System.out.println("Exception has been handled!");
        }

    }
}
