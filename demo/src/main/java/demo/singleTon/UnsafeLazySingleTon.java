package demo.singleTon;

/**
 * @Description: 懒汉模式，线程不安全
 * @Author: hongyan
 * @Date: 2022/5/14
 **/
public class UnsafeLazySingleTon {
    private static UnsafeLazySingleTon instance;
    /**构造方法私有， 别的类就无法创建该类的实例对象了
     * 缺点，线程不安全， 可能有多个线程同时创建， 导致创建了多个对象， 用反射调用也是线程不安全的
     **/
    private UnsafeLazySingleTon() {}
    public static UnsafeLazySingleTon getInstance() {
        if (instance == null) {
            instance = new UnsafeLazySingleTon();
        }
        return instance;
    }
}
