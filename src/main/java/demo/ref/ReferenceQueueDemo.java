package demo.ref;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/19 20:06
 * @description：引用队列. 当软引用、弱引用、虚引用被GC回收时， 会先进引用队列保存一下
 */
public class ReferenceQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        ReferenceQueue<Object> que = new ReferenceQueue<>();
        WeakReference<Object> o2 = new WeakReference<>(o1, que);

        System.out.println(o1);
        System.out.println(o2.get());
        System.out.println(que.poll());

        System.out.println("=================================");
        o1 = null;
        System.gc();
        TimeUnit.MILLISECONDS.sleep(500L);

        System.out.println(o1);
        System.out.println(o2.get());
        System.out.println(que.poll());

    }
}
