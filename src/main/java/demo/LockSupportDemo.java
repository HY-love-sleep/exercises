package demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/9 17:25
 * @description：LockSupportDemo
 */
public class LockSupportDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5L);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "come in");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "被唤醒");
        }, "A");

        a.start();

        Thread b = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "通知");
            LockSupport.unpark(a);
        }, "B");
        b.start();
    }

}
