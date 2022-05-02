package leetcode.solution;

import org.junit.Test;

public class Solution54 {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i < amount + 1; i++) {
            dp[0][i] = amount + 1;
        }
        for (int i = 1; i < coins.length + 1; i++) {
            int coin = coins[i - 1];
            for (int j = 1; j < amount + 1; j++) {
                if (coin > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coin] + 1);
                }
            }
        }
        return dp[coins.length][amount] != amount + 1 ? dp[coins.length][amount] : -1;
    }

    @Test
    public void test() {
        int[] coins = {2};
        int amount = 0;
        System.out.println(coinChange(coins, amount));
    }
}
