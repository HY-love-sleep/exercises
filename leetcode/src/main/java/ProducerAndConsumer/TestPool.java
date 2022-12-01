package ProducerAndConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/26 23:21
 * @description：111
 */
public class TestPool {
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final Long KEEP_ALIVE_TIME= 1L;
    private static final int QUEUE_SIZE = 100;

    public static void main(String[] args) {
        ThreadPoolExecutor executor  = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_SIZE),
                new ThreadPoolExecutor.AbortPolicy()
        );

        Box b = new Box();

        Producer p = new Producer(b);
        Consumer c = new Consumer(b);

        executor.execute(p);
        executor.execute(c);

        executor.shutdown();
    }
}
