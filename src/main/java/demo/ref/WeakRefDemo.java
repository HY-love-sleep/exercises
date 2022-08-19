package demo.ref;

import java.lang.ref.WeakReference;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/19 18:23
 * @description：弱引用， 生命周期更短， 只要进行垃圾回收， 就会回收弱引用
 */
public class WeakRefDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        WeakReference<Object> o2 = new WeakReference<>(o1);
        System.out.println("o1 == " + o1);
        System.out.println("o2 == " + o2.get());
        System.out.println("=====================");
        o1 = null;
        System.gc();
        System.out.println("o1 == " + o1);
        System.out.println("o2 == " + o2.get());

        ThreadLocal<Thread> threadThreadLocal = new InheritableThreadLocal<>();
    }
}
