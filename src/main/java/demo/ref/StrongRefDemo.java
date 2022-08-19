package demo.ref;

import sun.lwawt.macosx.CSystemTray;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/19 17:52
 * @description：强引用. 即使发生OOM了， 垃圾回收器也不会回收强引用指向的对象
 */
public class StrongRefDemo {
    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = obj1;
        obj1 = null;
        System.gc();
        System.out.println("obj1=======" + obj1);
        System.out.println("obj2=======" + obj2);
    }
}
