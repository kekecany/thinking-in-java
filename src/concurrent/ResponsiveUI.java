package concurrent;

import java.io.IOException;

/**
 * Created by yangyang on 2017/4/29 14:38.
 */
class UnresponsiveUI {
    private volatile double d = 1;
    public UnresponsiveUI() throws IOException{
        while (d > 0) {
            d += (Math.PI + Math.E) / d;
        }
        System.in.read();
    }
}

public class ResponsiveUI extends Thread {
    private static volatile double d = 1;
    public ResponsiveUI() {
        setDaemon(true);
        start();
    }
    public void run() {
        while (true) {
            d += (Math.PI + Math.E) / d;
        }
    }

    public static void main(String[] args) throws Exception{
        //new UnresponsiveUI();
        new ResponsiveUI();
        System.in.read();
        System.out.println(d);
    }
}
