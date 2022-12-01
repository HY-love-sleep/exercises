package demo.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @author ：hongyan
 * @date ：Created in 2022/8/24 10:27
 * @description：测试 一个类A方法加锁， b方法不加锁， 能互相访问吗
 */
class Resource {
    private int val;

    public Resource(int val) {
        this.val = val;
    }

    public synchronized void A() {
        System.out.println(Thread.currentThread().getName() + "method A ");
    }

    public void B() {
        System.out.println("method B");
        A();
    }
}

public class Test {
    public static void main(String[] args) {
        Resource resource = new Resource(3);
        resource.B();
    }
}
