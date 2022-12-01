package ProducerAndConsumer;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Box b = new Box();

        Producer p = new Producer(b);
        Consumer c = new Consumer(b);

        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);

        t1.start();
        t2.start();

        Thread.sleep(5000);

        t1.stop();
        t2.stop();
    }
}
