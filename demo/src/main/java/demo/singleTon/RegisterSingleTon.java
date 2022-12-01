package demo.singleTon;

/**
 * @Description: 登记方式实现单例
 * 延迟加载，线程安全，也不会造成资源浪费（就因为包了一层静态内部类？）
 * @Author: hongyan
 * @Date: 2022/5/14
 **/
public class RegisterSingleTon {
    private RegisterSingleTon() {}

    // 静态内部类
    private static class RegisterSingleTonGet{
        private static RegisterSingleTon instance = new RegisterSingleTon();
    }

    public static RegisterSingleTon getInstance() {
        return RegisterSingleTonGet.instance;
    }
}
