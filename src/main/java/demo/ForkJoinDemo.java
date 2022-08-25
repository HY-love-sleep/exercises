package demo;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/25 14:58
 * @description：fork/join框架 类似于分治法， 把大的任务分割成小的任务， 并行执行
 * 关键词 ：
 * 工作窃取算法： 维护一个双端队列， 线程执行完自己的工作后可以去别的线程队列中从队尾拿任务进行消费
 * 继承RecursiveTask<T>, 实现compute方法， 设定阈值， 将任务切割成阈值大小的子任务【fork】
 * 任务执行完毕后进行join， 也就是一个递归的过程；
 * forkJoinPool.submit (task);
 * Future<> result. get();
 */
class CountTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 5;

    private int start;
    private int end;

    public CountTask() {
    }

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int res = 0;
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                res += i;
            }
        } else {
            int mid = start + ((end - start) >> 1);
            CountTask leftTask = new CountTask(start, mid);
            CountTask rightTask = new CountTask(mid + 1, end);
            leftTask.fork();
            rightTask.fork();

            int leftResult = leftTask.join();
            int rightResult= rightTask.join();
            res = leftResult + rightResult;
        }
        return res;
    }
}
public class ForkJoinDemo {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask countTask = new CountTask(1, 100);
        Future<Integer> result = forkJoinPool.submit(countTask);
        try {
            System.out.println(result.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
