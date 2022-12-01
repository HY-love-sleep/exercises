package leetcode.prepare.autumn;

/**
 * @author ：hongyan
 * @date ：Created in 2022/5/13 17:11
 * @description：剪绳子I
 */
public class Solution14 {
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3;
        int b = n % 3;
        if (b == 0) {
            return (int)Math.pow(3, a);
        } else if (b == 1) {
            return (int)Math.pow(3, a - 1) * 4;
        } else {
            return (int)Math.pow(3, a) * 2;
        }
    }

    public int cuttingRopes(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
