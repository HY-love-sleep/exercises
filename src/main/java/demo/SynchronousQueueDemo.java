package demo;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/16 17:57
 * @description：单元素阻塞队列
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "  put 1");
                synchronousQueue.put("1");
                System.out.println(Thread.currentThread().getName() + "  put 2");
                synchronousQueue.put("2");
                System.out.println(Thread.currentThread().getName() + "  put 3");
                synchronousQueue.put("3");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "  get " + synchronousQueue.take());
                TimeUnit.SECONDS.sleep(2L);
                System.out.println(Thread.currentThread().getName() + "  get " + synchronousQueue.take());
                TimeUnit.SECONDS.sleep(2L);
                System.out.println(Thread.currentThread().getName() + "  get " + synchronousQueue.take());
                TimeUnit.SECONDS.sleep(2L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();
    }
}
