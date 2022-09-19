/**
 * @author ：hongyan
 * @date ：Created in 2022/9/14 13:28
 * @description：test
 */
public class Test {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                dianping();
            }
        };

        t.start();
        System.out.println("dazhong");

    }
    static void dianping() {
        System.out.println("dianping");
    }
}
