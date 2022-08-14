package demo.singleTon;

/**
 * @Description: 懒汉模式， 线程安全
 * 但一直加锁会造成资源浪费
 * @Author: hongyan
 * @Date: 2022/5/14
 **/
public class SafeLazySingleTon {
    private static SafeLazySingleTon instance;
    private SafeLazySingleTon() {}
    public static synchronized SafeLazySingleTon getInstance() {
        if (instance == null) {
            instance = new SafeLazySingleTon();
        }
        return instance;
    }
}
