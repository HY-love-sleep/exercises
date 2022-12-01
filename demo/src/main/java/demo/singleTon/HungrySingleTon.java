package demo.singleTon;

/**
 * @Description: 饿汉模式，当类初始化时就会被实例化， 但一直不用会一直占用一部分内存
 * 普通调用是线程安全的
 * 多线程调用也是安全的
 * 但是容易产生垃圾
 * @Author: hongyan
 * @Date: 2022/5/14
 **/
public class HungrySingleTon {
    private HungrySingleTon() {}
    // 创建对象
    private static HungrySingleTon instance = new HungrySingleTon();
    // 对外接口
    public static HungrySingleTon getInstance() {
        return instance;
    }
    // 测试类写在test目录下
}
