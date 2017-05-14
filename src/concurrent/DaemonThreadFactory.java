package concurrent;

import java.util.concurrent.ThreadFactory;

/**
 * Created by yangyang on 2017/4/16 17:05.
 */
public class DaemonThreadFactory implements ThreadFactory{
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }

    public static void main(String[] args) {
        System.out.println(Integer.SIZE);
    }
}
