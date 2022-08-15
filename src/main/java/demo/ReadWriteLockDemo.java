package demo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/15 22:14
 * @description：读写锁， 经典的案例就是缓存， 对于缓存来说， 读应该是允许大家一起读的， 但是写操作需要需要保证是独占且原子性的
 */
class Cache {
    private volatile Map<String, Object> myCache = new HashMap<>();
    // 读写锁
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void put(String key, Object value) throws InterruptedException {
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "  正在写入      " + key);
            TimeUnit.MILLISECONDS.sleep(500L);
            myCache.put(key, value);
            System.out.println(Thread.currentThread().getName() + "  写入完成");
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    public void get(String key) throws InterruptedException {
        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "  正在读取");
            TimeUnit.MILLISECONDS.sleep(500L);
            Object result = myCache.get(key);
            System.out.println(Thread.currentThread().getName() + "  读取完成    " + key);
        } finally {
            rwLock.readLock().unlock();
        }
    }
}

/**
 * 多个线程同时读一个共享资源类不会有任何问题， 所以为了保证并发量， 读取共享资源应该能够同时进行；
 * 但是如果某一线程想去写共享资， 那么就不应该有其他线程同时对这个共享资源进行读或者写
 * 总结：
 * 1、读-读 共存
 * 2、读-写 加锁
 * 3、写-读 加锁
 *
 * 写操作： 原子 + 独占， 整个写过程应该是一体的， 不能被分割和打断
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) {
        Cache cache = new Cache();
        // 五个线程去写
        for (int i = 0; i < 5; i++) {
            final int finalI = i;
            new Thread(() -> {
                try {
                    cache.put(finalI+"", finalI+"");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }

        // 五个线程去读
        for (int i = 0; i < 5; i++) {
            final int finalI = i;
            new Thread(() -> {
                try {
                    cache.get(finalI+"");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
