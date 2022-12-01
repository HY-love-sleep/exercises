package demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/16 22:22
 * @description： 题目：
 *
 * 多线程间按顺序调用， 实现A->B->C三个线程启动，要求如下：
 * AA打印5次，BB打印10次，CC打印15次
 * 循环10轮
 *
 */
class ShardResource {
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5() throws InterruptedException {
        lock.lock();
        try {
            // 判断
            while (number != 1) {
                c1.await();
            }

            // 干活
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "=====>" + i);
            }

            // 通知
            number = 2;
            c2.signal();
        } finally {
            lock.unlock();
        }
    }

    public void print10() throws InterruptedException {
        lock.lock();
        try {
            // 判断
            while (number != 2) {
                c2.await();
            }

            // 干活
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "=====>" + i);
            }

            // 通知
            number = 3;
            c3.signal();
        } finally {
            lock.unlock();
        }
    }

    public void print15() throws InterruptedException {
        lock.lock();
        try {
            // 判断
            while (number != 3) {
                c1.await();
            }

            // 干活
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + "=====>" + i);
            }

            // 通知
            number = 1;
            c1.signal();
        } finally {
            lock.unlock();
        }
    }
}
public class SyncAndReentrantLockDemo {
    public static void main(String[] args) {
        ShardResource sr = new ShardResource();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    sr.print5();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "A").start();

            new Thread(() -> {
                try {
                    sr.print10();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "B").start();

            new Thread(() -> {
                try {
                    sr.print15();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "C").start();
        }
    }
}
