package ThreadTest;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/27 10:54
 * @description：producer
 */
public class Producer implements Runnable{
    Box b;
    public Producer(Box b) {
        this.b = b;
    }
    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            b.putMilk(i);
        }
    }
}
