package demo;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/9 15:58
 * @description：synchronizeDemo
 */
public class Synchronize {
    static Object objectLockA = new Object();

    public static void main(String[] args) {
        Thread A = new Thread(() -> {
            synchronized (objectLockA) {
                System.out.println(Thread.currentThread().getName() + "======进入外层当方法");
                synchronized (objectLockA) {
                    System.out.println(Thread.currentThread().getName() + "======进入中层当方法");
                    synchronized (objectLockA) {
                        System.out.println(Thread.currentThread().getName() + "======进入内层当方法");
                    }
                }
            }
        });
        A.start();
    }
}
