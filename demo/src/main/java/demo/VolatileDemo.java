package demo;

import lombok.Synchronized;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/12 17:56
 * @description：验证volatile可见性， volatile能及时通知其他线程， 主内存中的变量已经被修改；
 */
class MyData {
    volatile int number = 0;
    AtomicInteger atomicNumber = new AtomicInteger(0);

    public void addToOne() {
        this.number = 1;
    }

    public void addPlusPlus() {
        this.number++;
    }

    public void atomicAdd() {
        atomicNumber.getAndIncrement();
    }
}

public class VolatileDemo {
    public static void main(String[] args) {
        MyData myData = new MyData();
        /** 1、volatile 能保证可见性*/
//        new Thread(() -> {
//            System.out.println(Thread.currentThread().getName() + "   come in");
//            try {
//                TimeUnit.SECONDS.sleep(3L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            myData.addToOne();
//            System.out.println(Thread.currentThread().getName() + "   updated number to " + myData.number);
//        }, "A").start();
//
//        while (myData.number == 0) {
//            // 空转
//        }
//
//        System.out.println(Thread.currentThread().getName() + "   mission is overed , new number is " + myData.number);

        /** volatile 无法保证原子性*/
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    myData.addPlusPlus();
                    myData.atomicAdd();
                }
            }, String.valueOf(i)).start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + "  number is " + myData.number);
        System.out.println(Thread.currentThread().getName() + "  atomic number is " + myData.atomicNumber);
    }
}
