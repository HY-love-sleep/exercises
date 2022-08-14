package demo.singleTon;

/**
 * @Description: 通过枚举类实现单例
 * 线程安全， 还能防止多次实例化
 * 缺点是不能被继承
 * @Author: hongyan
 * @Date: 2022/5/14
 **/
public enum EnumSingleTon {
    INSTANCE;
    public void whateverMethod() {
        System.out.println("枚举方式");
    }
}
