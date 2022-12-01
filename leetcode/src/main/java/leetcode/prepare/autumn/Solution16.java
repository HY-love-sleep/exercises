package leetcode.prepare.autumn;

import org.junit.Test;

/**
 * @author ：hongyan
 * @date ：Created in 2022/5/17 16:42
 * @description：数值的整数次方
 */
public class Solution16 {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
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
        System.out.println(myPow(2, 0));
    }
}
