package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yangyang on 2017/4/29 15:33.
 */
public class SettingDefaultHandler {

    public static void main(String[] args) {
        //Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println(Thread.getDefaultUncaughtExceptionHandler());
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
    }
}
