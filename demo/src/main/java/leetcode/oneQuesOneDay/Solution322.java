package leetcode.oneQuesOneDay;

import java.util.Arrays;

/**
 * @author ：hongyan
 * @date ：Created in 2022/10/10 16:11
 * @description：零钱兑换
 */
public class Solution322 {
    /**
     * dp[i] : 凑出面值为i的金额所需的最小硬币数；
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                } else {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
