package demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/17 14:50
 * @description：callable
 */
class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("========= come in callable =============");
        TimeUnit.SECONDS.sleep(3L);
        return 1024;
    }
}
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        int a = 100;
        System.out.println("=======" + Thread.currentThread().getName() + "=======");
        new Thread(futureTask, "A").start();
        int b = futureTask.get();
        System.out.println("result  " + (a + b));
    }
}
