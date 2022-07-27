package ThreadTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/27 10:56
 * @description：test
 */
public class Test {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                5,
                10,
                1L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100),
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
