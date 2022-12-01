package leetcode.oneQuesOneDay;

import org.junit.Test;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/11 09:16
 * @description：Pow(x,n)
 */
public class Solution50 {
    public double myPow(double x, int n) {
        if (x == 0.0f) {
            return 0.0;
        }
        double res = 1.0;
        long b = n;
        if (b < 0) {
            b = -b;
            x = 1/ x;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(myPow(2.0, 10));
    }
}
