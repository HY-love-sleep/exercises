package demo;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/16 23:42
 * @description：阻塞队列版生产者消费者
 */

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 共享资源类 【蛋糕】
 */
class Cake {
    // flag == true : 可以生产  false： 停止生产
    private volatile boolean flag = true;

    // 原子类 开始有0个蛋糕
    private AtomicInteger atomicInteger = new AtomicInteger();

    // 阻塞队列
    private BlockingQueue<String> blockingQueue = null;

    public Cake() {
    }

    public Cake(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void myProd() throws InterruptedException {
        // 生产者往队列中放蛋糕
        String cake = null;
        boolean retValue;
        while (flag) {
            cake = atomicInteger.getAndIncrement() + "";
            retValue = blockingQueue.offer(cake, 2L, TimeUnit.SECONDS);
            if (retValue) {
                System.out.println(Thread.currentThread().getName() + "生产了蛋糕====" + cake + "=====号 成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "生产了蛋糕====" + cake + "=====号 失败！");
            }
            TimeUnit.SECONDS.sleep(1L);
        }
        System.out.println(Thread.currentThread().getName() + "     打烊了关门了不再生产蛋糕了");
    }

    public void myConsumer() throws InterruptedException {
        // 消费者从队列中取蛋糕
        String result = null;
        while (flag) {
            result = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (result == null || StringUtils.isEmpty(result)) {
                flag = false;
                System.out.println(Thread.currentThread().getName() + "超过2S没取到蛋糕， 不买了");
                 return;
            }
            System.out.println(Thread.currentThread().getName() + "消费了蛋糕====" + result + "=====号");
        }
        System.out.println("打烊了关门了不再生产蛋糕了");
    }

    public void stop() {
        flag = false;
    }

}
public class ProdConsumerBlockQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        Cake resource = new Cake(new ArrayBlockingQueue<>(5));
        new Thread(() -> {
            try {
                System.out.println("生产者开始工作！");
                resource.myProd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"producer").start();

        new Thread(() -> {
            try {
                System.out.println("消费者开始工作！");
                resource.myConsumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"consumer").start();

        // 蛋糕店开门5S
        TimeUnit.SECONDS.sleep(5);

        // 结束营业
        resource.stop();
    }
}
