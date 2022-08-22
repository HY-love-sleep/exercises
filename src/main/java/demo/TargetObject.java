package demo;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/22 10:45
 * @description：想通过反射获取的目标类
 */
public class TargetObject {
    private String s;
    public TargetObject() {
        s = "changchang";
    }

    public void publicMethod(String s) {
        System.out.println("publicMethod" + s);
    }

    private void privateMethod() {
        System.out.println("i love" + s);
    }
}
