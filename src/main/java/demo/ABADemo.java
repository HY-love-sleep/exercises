package demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/14 19:33
 * @description：ABA问题
 */
public class ABADemo {
    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);

    public static void main(String[] args) {
        /** ABA 问题的产生*/
//        new Thread(() -> {
//            atomicReference.compareAndSet(100, 101);
//            atomicReference.compareAndSet(101, 100);
//        }).start();
//
//        new Thread(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(1L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(atomicReference.compareAndSet(100, 2022) + " current value is " + atomicReference.get());
//        }).start();


        /** ABA 问题的解决【atomicStampedReference】*/
        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "第一次获取的版本号为  " + stamp);
            try {
                TimeUnit.SECONDS.sleep(1L); // 让线程B同样拿到版本号为1的value
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(100, 101, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "进行了第一次修改， 此时 value = " + atomicStampedReference.getReference() + "   stamp = " + atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "进行了第二次修改， 此时 value = " + atomicStampedReference.getReference() + "   stamp = " + atomicStampedReference.getStamp());
        }, "A").start();

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "第一次获取的版本号为  " + stamp);
            try {
                TimeUnit.SECONDS.sleep(3L); // 让线程A 执行完ABA
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("B线程执行成功 ？     " + atomicStampedReference.compareAndSet(100, 2022, stamp, stamp + 1) + "  此时value = " + atomicStampedReference.getReference() + "stamp = " + atomicStampedReference.getStamp());
        }, "B").start();

    }
}
