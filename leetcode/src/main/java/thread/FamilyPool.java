package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/26 22:48
 * @description：家里
 */
public class FamilyPool {
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

        Plate plate = new Plate();

        Baba honghanyang = new Baba(plate);
        Wo hongyan = new Wo(plate);

        executor.execute(honghanyang);
        executor.execute(hongyan);

        try {
            executor.shutdown();
        } catch (Exception e) {
            System.out.println("线程池销毁失败" + e.getMessage());
        }
    }
}
