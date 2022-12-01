package ProducerAndConsumer;

public class Consumer implements Runnable{

    private Box b;

    public Consumer(Box box) {
        this.b = box;
    }

    @Override
    public void run() {
        while (true) {
            b.getMilk();
        }
    }
}
