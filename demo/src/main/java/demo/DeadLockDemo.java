package demo;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/18 11:36
 * @description：产生死锁的原因 ： 两个或者多个线程互相持有对方的锁并尝试获取对方的锁， 进入一个互相等待的状态
 * 解决方法 1、jps -l 定位进程号
 *         2、 jstack 进程号查看死锁原因
 */

class HoldLockThread implements Runnable{
    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        try {
            synchronized (lockA) {
                System.out.println(Thread.currentThread().getName() + "获取了锁" + lockA + "  并尝试获取锁" + lockB);
                synchronized (lockB) {
                    System.out.println(Thread.currentThread().getName() + "获取了锁" + lockB);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2,5,2L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        try {
            threadPool.execute(new HoldLockThread(lockA, lockB));
            threadPool.execute(new HoldLockThread(lockB, lockA));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
