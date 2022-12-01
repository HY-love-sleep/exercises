package demo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/16 16:00
 * @description：信号量
 */
public class SemaphoreDemo {
    /**
     * 六个人抢占三个车位
     * @param args
     */
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "  抢占到了停车位");
                    TimeUnit.SECONDS.sleep(3L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().getName() + "  离开了停车位");
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}
