package demo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WaitNotify {
    private static boolean flag = true;
    private static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new Thread(new Wait(), "等待线程");
        waitThread.start();
        Thread.sleep(1000);
        Thread notifyThread = new Thread(new Notify(), "通知线程");
        notifyThread.start();
    }

    static class Wait implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread().getName() +
                                ":    小洪在打游戏，畅畅不可以打扰他" +
                                new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait();
                    } catch (InterruptedException e){}
                }
                // 条件满足时完成工作
                System.out.println(Thread.currentThread().getName() +
                        ":    小洪打完游戏了，可以陪畅畅玩啦" +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }

    static class Notify implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() +
                        ":    获得通知锁， 小洪快打完了， 通知小畅来玩耍" +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));

                lock.notifyAll();
                flag = false;
                try {  //证明notify()了之后等待线程不会立即进入running状态， 而是先阻塞， 等待对象锁的释放
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // 再次获得锁
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() +
                        ":    再次获得通知锁， 小洪快打完了， 通知小畅来玩耍" +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
                try {  //证明notify()了之后等待线程不会立即进入running状态， 而是先阻塞， 等待对象锁的释放
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
