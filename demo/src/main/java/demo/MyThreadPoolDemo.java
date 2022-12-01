package demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/17 15:52
 * @description：线程池
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        /**
         * 一池5线程
         */
        ExecutorService threadPool1 = Executors.newFixedThreadPool(5);
        ExecutorService threadPool2 = Executors.newSingleThreadExecutor();
        ExecutorService threadPool3 = Executors.newCachedThreadPool();
        try {
            // 线程池有5个线程， 十个用户来办理业务
            for (int i = 1; i <= 10; i++) {
                threadPool3.execute(() -> {

                    try {
                        System.out.println(Thread.currentThread().getName() + "办理业务");
                        TimeUnit.MILLISECONDS.sleep(2000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        } finally {
            threadPool3.shutdown();
        }
    }
}
