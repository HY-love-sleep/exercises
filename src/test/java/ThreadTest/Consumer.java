package ThreadTest;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/27 10:55
 * @description：consumer
 */
public class Consumer implements Runnable{
    Box b;

    public Consumer(Box b) {
        this.b = b;
    }

    @Override
    public void run() {
        while (true) {
            b.getMilk();
        }
    }
}
