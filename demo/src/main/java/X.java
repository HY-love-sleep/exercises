import java.util.concurrent.atomic.AtomicBoolean;
/**
 * 交替打印字母与数字
 * 1A2B3C...
 * 保证先打印数字
 * @author IT00ZYQ
 * @date 2021/5/31 21:13
 **/
public class X {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        char[] cc = "ABCDEFGH".toCharArray();
        char[] nn = "12345678".toCharArray();
        // tag变量是为了保证数字线程先打印，防止出现A1B2...
        AtomicBoolean tag = new AtomicBoolean(false);

        new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < nn.length; i++) {
                    tag.set(true);
                    System.out.print(nn[i]);
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 没有最后的notify()，后打印字母的线程会一直处于阻塞状态，程序不会结束
                lock.notify();
            }
        }).start();


        new Thread(() -> {
            synchronized (lock) {
                while (!tag.get()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 0; i < cc.length; i++) {
                    System.out.print(cc[i]);
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}