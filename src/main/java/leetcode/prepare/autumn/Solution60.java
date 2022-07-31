package leetcode.prepare.autumn;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/31 10:13
 * @description：骰子
 */
public class Solution60 {
    public double[] dicesProbability(int n) {
        int min = n, max = n * 6;
        double[][] dp = new double[n + 1][n * 6 + 1];
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1 / 6.0;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= i * 6; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j - k <= 0) {
                        continue;
                    }
                    dp[i][j] += dp[i - 1][j - k] * 1 / 6.0;
                }
            }
        }
        double[] res = new double[max - min + 1];
        for (int k = min; k <= max; k++) {
            res[k - min] = dp[n][k];
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(dicesProbability(2)));
    }
}
