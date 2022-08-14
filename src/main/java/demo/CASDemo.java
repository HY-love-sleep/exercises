package demo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/11 10:36
 * @description：三个线程将num从0累加到100
 */
public class CASDemo {
//    static Integer num = 0;
    static AtomicInteger num = new AtomicInteger(0);
    static Object lock = new Object();
//    public static void main(String[] args) {
//        for (int i = 0; i < 3; i++) {
//            new Thread(() -> {
//                synchronized (lock) {
//                    while (num < 100) {
//                        System.out.println(Thread.currentThread().getName() + "===>" + ++num);
//                    }
//                }
//            }).start();
//        }
//    }

    public static void main(String[] args) {
//        for (int i = 0; i < 3; i++) {
//            new Thread(() -> {
//                while (num.get() < 100) {
//                    System.out.println(Thread.currentThread().getName() + "===>" + num.addAndGet(1));
//                }
//            }).start();
//        }

        System.out.println(num.compareAndSet(0, 1) + "  current num is : " + num);
    }
}
