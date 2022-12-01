package demo.ref;

import java.lang.ref.SoftReference;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/19 18:03
 * @description：软引用【内存够用就不会回收， 内存不够用时会回收软引用】
 */
public class SoftRefDemo {
    public static void softRef_Enough_memory() {
        Object o1 = new Object();
        SoftReference<Object> o2 = new SoftReference<>(o1);
        System.out.println("o1 == " + o1);
        System.out.println("o2 == " + o2.get());
        o1 = null;
        System.gc();
        System.out.println("GC 喽");
        System.out.println("o1 == " + o1);
        System.out.println("o2 == " + o2.get());
    }

    public static void softRef_NotEnough_memory() {
        Object o1 = new Object();
        SoftReference<Object> o2 = new SoftReference<>(o1);
        System.out.println("o1 == " + o1);
        System.out.println("o2 == " + o2);
        o1 = null;
        try {
            // 开辟一个20M的数组， 通过 -Xms5m -Xmx5m 将JVM堆内存设置为5m来模拟OOM
            byte[] arrays = new byte[20 * 1024 * 1024];
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("o1 == " + o1);
            System.out.println("o2 == " + o2.get());
        }
    }


    public static void main(String[] args) {
//        softRef_Enough_memory();
        softRef_NotEnough_memory();
    }
}
