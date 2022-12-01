package leetcode.oneQuesOneDay;

import org.junit.Test;

/**
 * @author ：hongyan
 * @date ：Created in 2022/10/10 12:23
 * @description：零钱兑换②
 */
public class Solution518 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][ amount + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[n][amount];
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 5};
        System.out.println(change(5, nums));
    }
}
