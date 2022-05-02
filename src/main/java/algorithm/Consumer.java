package algorithm;

public class Consumer implements Runnable{
    private Box x;

    public Consumer(Box x) {
        this.x = x;
    }

    @Override
    public void run() {
        while (true) {
            x.getOrange();
        }
    }
}
