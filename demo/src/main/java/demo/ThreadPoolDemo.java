package demo;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/17 18:16
 * @description：手动设置线程池
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2,
                5,
                20L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        // 核心线程2， 最大线程5
        /**
         * 八个客户来办理业务
         * 头两个立刻得到受理
         * 后三个进等待队列
         * 最后三个进来会直接新建三个线程去处理， 这样后三个任务相当于【优先级反转】了， 比等待队列中的任务更先得到执行!!!!!!!!!!!
         */
        try {
            for (int i = 1; i <= 8; i++) {
                final int temp = i;
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "  顾客===" + temp + "===办理业务");
                    try {
                        TimeUnit.SECONDS.sleep(2L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        } finally {
            threadPool.shutdown();
        }
    }
}
