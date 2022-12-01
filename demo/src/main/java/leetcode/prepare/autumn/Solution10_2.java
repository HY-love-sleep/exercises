package leetcode.prepare.autumn;

import org.junit.Test;

public class Solution10_2 {
    public int numWays(int n) {
        final int MOD = 1000000007;
        if (n <= 1) {
            return 1;
        }
        int a = 1, b = 1, c = 1;
        for (int i = 2; i <= n; i++) {
            a = b;
            b = c;
            c = (a + b) % MOD;
        }
        return c;
    }

    @Test
    public void test() {
        System.out.println(numWays(3));
    }
}
