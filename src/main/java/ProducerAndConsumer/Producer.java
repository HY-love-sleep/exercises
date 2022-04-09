package ProducerAndConsumer;

public class Producer implements Runnable{

    private final Box b;

    public Producer(Box box) {
        this.b = box;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            b.putMilk(i);
        }
    }
}
