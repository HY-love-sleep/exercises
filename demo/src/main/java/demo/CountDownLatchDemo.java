package demo;

import java.util.Objects;
import java.util.concurrent.CountDownLatch;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/16 11:03
 * @description：CountDownLatchDemo
 */
public class CountDownLatchDemo {
    /**
     * 控制6名同学都离开教室了班长才能锁门
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        // closeDoor();
        warringStates();
    }

    public static void closeDoor() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println("同学" + Thread.currentThread().getName() + "  离开了教室");
                // 计数器， 每位同学离开就将计数器减一
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }

        // 计数器为0时通知主线程唤醒
        countDownLatch.await();
        System.out.println("班长" + Thread.currentThread().getName() + "  锁上了门");
    }

    /**
     * 秦灭六国（枚举类）
     */
    public static void warringStates() throws InterruptedException {
        CountDownLatch timer = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                String name = Thread.currentThread().getName();
                System.out.println(Objects.requireNonNull(CountryEnum.getEnum(Integer.parseInt(name))).getRetMsg() + "国被灭");
                timer.countDown();
            }, String.valueOf(i)).start();
        }

        timer.await();
        System.out.println(CountryEnum.getEnum(0).getRetMsg() +  "国一统天下");
    }
}
