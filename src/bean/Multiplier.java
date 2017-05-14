package bean;

import annotations.ExtractInterface;

/**
 * Created by yangyang on 2017/3/24 23:05.
 */
@ExtractInterface("IMultiplier")
public class Multiplier {
    public int multi(int x, int y) {
        int total = 0;
        for (int i = 0; i < x; i++) {
            total = add(total, y);
        }
        return total;
    }

    private int add(int x, int y) {
        return x + y;
    }

    public static void main(String[] args) {
        Multiplier m = new Multiplier();
        System.out.println("11*16 = " + m.multi(11, 16));
    }
}
