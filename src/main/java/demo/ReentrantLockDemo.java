package demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/9 16:24
 * @description：可重入锁
 */
public class ReentrantLockDemo {
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "===========》外");
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + "===========》内");
                } finally {
                    lock.unlock();
                }
            } finally {
                lock.unlock();
            }
        }, "t1").start();
    }
}
