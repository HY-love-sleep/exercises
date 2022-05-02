package algorithm;

public class Test {
    public static void main(String[] args) {
        Box x = new Box();

        Producer p = new Producer(x);
        Consumer c = new Consumer(x);

        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);

        t1.start();
        t2.start();
    }
}
