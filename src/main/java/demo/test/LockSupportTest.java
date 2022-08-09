package demo.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/9 20:36
 * @description：循环打印ABCABC, ABC三个线程只会打印ABC， 用第四个线程去控制他们打印的顺序
 */
public class LockSupportTest {
    static volatile int i = 0;
    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            while (true) {
                LockSupport.park();
                System.out.println(Thread.currentThread().getName() + "=======> A");
            }
        }, "A");

        Thread b = new Thread(() -> {
            while (true) {
                LockSupport.park();
                System.out.println(Thread.currentThread().getName() + "=======> B");
            }
        }, "B");

        Thread c = new Thread(() -> {
            while (true) {
                LockSupport.park();
                System.out.println(Thread.currentThread().getName() + "=======> C");
            }
        }, "C");

        Thread dispatcher = new Thread(() -> {
            try {
                while (i < 20) {
                    if ((i % 3) == 0) {
                        LockSupport.unpark(a);
                    } else if ((i % 3) == 1) {
                        LockSupport.unpark(b);
                    } else {
                        LockSupport.unpark(c);
                    }
                    i++;
                    TimeUnit.SECONDS.sleep(1L); // 这里如果不sleep的话是不会按顺序打印的， 猜测是因为while循环执行太快， A被唤醒还没来得及打印， B就被唤醒了
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        a.start();
        b.start();
        c.start();
        dispatcher.start();
    }
}
