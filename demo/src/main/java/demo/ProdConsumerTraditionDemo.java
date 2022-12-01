package demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/16 20:22
 * @description：生产者消费者(传统写法)
 * 多线程编程口诀 ：
 *     线程    操作    资源类
 *     判断    干活    通知
 */
class ShareData {
    /**
     * 两个线程对number进行操作， 一个+1， 一个-1 （模拟生产者消费者）
     */
    private int number;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    // 生产者（number++）
    public void increment() throws InterruptedException {
        lock.lock();
        try {
            // 1、判断
            while (number != 0) {
                condition.await();
            }
            // 2、干活
            number++;
            System.out.println(Thread.currentThread().getName() + number);
            // 3、通知
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    // 消费者 （number--）
    public void decrement() throws InterruptedException {
        lock.lock();
        try {
            // 1、判断
            while (number == 0) {
                condition.await();
            }
            // 2、干活
            number--;
            System.out.println(Thread.currentThread().getName() + number);
            // 3、通知
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
public class ProdConsumerTraditionDemo {
    public static void main(String[] args) {
        ShareData sd = new ShareData();

        /**
         * A线程生产5次， B线程消费5次
         */
        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    sd.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    sd.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
    }
}
