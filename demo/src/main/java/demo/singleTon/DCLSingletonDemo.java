package demo.singleTon;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/14 14:56
 * @description：双重校验锁单例模式
 */
public class DCLSingletonDemo {
    private static volatile DCLSingletonDemo instance = null;

    public static DCLSingletonDemo getInstance() {
        if (instance == null) {
            synchronized (DCLSingletonDemo.class) {
                if (instance == null) {
                    instance = new DCLSingletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {

    }
}
