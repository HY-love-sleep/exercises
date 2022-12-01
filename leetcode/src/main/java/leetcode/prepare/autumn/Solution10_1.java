package leetcode.prepare.autumn;

import org.junit.Test;

public class Solution10_1 {
    public int fib(int n) {
        final int MOD = 1000000007;
        if (n < 2) {
            return n;
        }
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <=n; i++) {
            p = q;
            q = r;
            r = (p + q) % MOD;
        }
        return r;
    }

    @Test
    public void test() {
        System.out.println(fib(44));
    }
}
