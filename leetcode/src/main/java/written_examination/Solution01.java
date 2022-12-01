package written_examination;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/20 16:43
 * @description：11
 */
class P {
    void f (int i) {
        System.out.println(i);
    }
}

class Q extends P {
    @Override
    void f (int i) {
        System.out.println(2 * i);
    }
}
public class Solution01 {
    public static void main(String[] args) {
        P x = new Q();
        Q y = new Q();
        P z = new Q();
        x.f(1);
        ((P)y).f(1);
        z.f(1);
    }
}
