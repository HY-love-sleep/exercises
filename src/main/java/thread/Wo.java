package thread;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/26 22:46
 * @description：wo
 */
public class Wo implements Runnable{
    private Plate p;
    public Wo(Plate p) {
        this.p = p;
    }

    @Override
    public void run() {
        while(true) {
            p.getApple();
        }
    }
}
