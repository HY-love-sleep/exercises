package leetcode.oneQuesOneDay;

import org.junit.Test;

/**
 * @author ：hongyan
 * @date ：Created in 2022/10/10 10:45
 * @description：分割等和子集（背包）
 * dp[i][j] 表示在数组的前i个num中， 是否有和为j 的子数组存在
 * dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]]
 */
public class Solution416 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        boolean[][] dp = new boolean[n + 1][sum / 2 + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= sum / 2; i++) {
            dp[0][i] = false;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum / 2 ; j++) {
                if (j - nums[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum / 2];
    }

    @Test
    public void test() {
        int[] nums = {1, 5, 11, 5};
        System.out.println(canPartition(nums));
    }
}
