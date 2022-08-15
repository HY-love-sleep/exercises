package demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/9 16:24
 * @description：可重入锁
 */
class Phone implements Runnable{

    Lock lock = new ReentrantLock();
    @Override
    public void run() {
        lock.lock();
        try {
            get();
        } finally {
            lock.unlock();
        }
    }

    private void get() {
        System.out.println(Thread.currentThread().getName() + "  invoked get()");
        set();
    }

    private void set() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "  invoked set()");
        } finally {
            lock.unlock();
        }
    }
}
public class ReentrantLockDemo {
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
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

        TimeUnit.SECONDS.sleep(1L);

        Phone p = new Phone();

        Thread A = new Thread(p,"A");
        A.start();
    }
}
