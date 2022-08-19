package demo.ref;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/19 20:22
 * @description：虚引用， 做一个通知作用
 */
public class PhanTomRefDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        ReferenceQueue<Object> que = new ReferenceQueue<>();
        PhantomReference<Object> o2 = new PhantomReference<>(o1, que);

        System.out.println(o1);  // Obj
        System.out.println(o2.get()); // null
        System.out.println(que.poll()); // null

        System.out.println("================");
        o1 = null;
        System.gc();

        System.out.println(o1);  // null
        System.out.println(o2.get()); // null
        System.out.println(que.poll()); // ref

    }
}
