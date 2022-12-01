package demo;

import java.util.concurrent.TimeUnit;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/19 12:30
 * @description：GCRoots
 * 1、 虚拟机栈中引用的对象
 * 2、 方法区中静态变量引用的对象
 * 3、 方法区中常量引用的对象
 * 4、 本地方法栈中JNI引用的对象
 */
public class GCRootDemo {

    /** 这就是虚拟机栈中引用的对象， 虚拟机栈中存放了方法的局部变量表*/
    private static void m1 () {
        GCRootDemo de = new GCRootDemo();
        System.gc();
        System.out.println("第一次GC完成");
    }

    /** 这就是方法区中的静态变量引用的对象*/
    private static GCRootDemo demo;

    /** 这就是方法区中的常量引用的对象*/
    private static final GCRootDemo demo2 = null;

    /** 之前学CAS时， unsafe类的compareAndSwapInt方法就是一个native方法， JNI引用的对象也是GC ROOT*/


    public static void main(String[] args) throws InterruptedException {
        System.out.println("======hello GC========");

        long totalMemory = Runtime.getRuntime().totalMemory(); // 返回java虚拟机中的内存总量
        long maxMemory = Runtime.getRuntime().maxMemory(); // 返回java虚拟机试图使用的最大内存量
        System.out.println("total memory（Xms）:" + totalMemory + "字节" +  (totalMemory / 1024 / 1024) + "MB");
        System.out.println("max memory（Xmx）:" + maxMemory + "字节" +  (maxMemory / 1024 / 1024) + "MB");

//        TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
        byte[] array = new byte[50 * 1024 * 1024];
    }

}
