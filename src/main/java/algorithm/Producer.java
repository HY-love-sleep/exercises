package algorithm;

public class Producer implements Runnable{
    private Box x;

    public Producer(Box x) {
        this.x = x;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            x.putOrange(i);
        }
    }
}
