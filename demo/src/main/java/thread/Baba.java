package thread;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/26 22:42
 * @description：producer
 */
public class Baba implements Runnable{
    private final Plate p;

    public Baba(Plate p) {
        this.p = p;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            p.putApple(i);
        }
    }
}
