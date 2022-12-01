package thread;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/26 21:51
 * @description：线程池demo
 */
public class ThreadPoolDemo {
    private static final int CORE_THREAD = 5;
    private static final int MAX_THREAD = 10;
    private static final long KEEP_ALIVE_TIME = 1L;
    private static final int QUEUE_CAPACITY = 100;

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_THREAD,
                MAX_THREAD,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        for (int i = 0; i < 10; i++) {
            Runnable worker = new MyRunnable(String.valueOf(i));
            executor.execute(worker);
        }

        try {
            executor.shutdown();
            while (!executor.isTerminated()) {
            }
            System.out.println("Thread pool is terminated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
