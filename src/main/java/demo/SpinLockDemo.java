package demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/15 17:13
 * @description：手写自旋锁
 */
public class SpinLockDemo {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    private void myLock() {
        Thread t = Thread.currentThread();

        while (!atomicReference.compareAndSet(null, t)) {
            // 不成功就一直尝试获取锁
        }
        System.out.println(t.getName() + "  come in !");
    }

    private void myUnlock() {
        Thread t = Thread.currentThread();
        atomicReference.compareAndSet(t, null);
        System.out.println(t.getName() + "  come out !");
    }

    public static void main(String[] args) throws InterruptedException {
        SpinLockDemo spinLockDemo = new SpinLockDemo();

        new Thread(() -> {
            spinLockDemo.myLock();
//            System.out.println(Thread.currentThread().getName() + " 获取到锁， 处理业务中。。。");
            try {
                TimeUnit.SECONDS.sleep(5L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println(Thread.currentThread().getName() + " 处理完成， 释放锁");
            spinLockDemo.myUnlock();
        }, "A").start();

        // 主线程休眠1s保证线程A先获取到锁
        TimeUnit.SECONDS.sleep(1L);

        new Thread(() -> {
            spinLockDemo.myLock();
            spinLockDemo.myUnlock();
        }, "B").start();
    }
}
