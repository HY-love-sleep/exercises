package leetcode.oneQuesOneDay;

import org.junit.Test;

/**
 * @author ：hongyan
 * @date ：Created in 2022/10/10 13:42
 * @description：目标和
 */
public class Solution494 {
    int result = 0;
    public int findTargetSumWays(int[] nums, int target) {
        /**
         * sum(A) = (target + sum(nums)) / 2;
         */
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((target + sum) % 2 == 1 || sum < Math.abs(target)) {
            return 0;
        }
        return subsets(nums, (target + sum) / 2);
    }

    /**
     * dp[i][j] 表示前i个数， 加起来等于j的组合有几种
     */
    private int subsets(int[] nums, int target) {
        int[][] dp = new int[nums.length + 1][target + 1];
        for (int i = 0; i < nums.length + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < target + 1; j++) {
                if (j - nums[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][target];
    }

    private void backtrack(int[] nums, int i, int remain) {
        if (i == nums.length) {
            if (remain == 0) {
                result += 1;
            }
            return;
        }

        // +
        remain -= nums[i];
        backtrack(nums, i + 1, remain);
        remain += nums[i];

        // -
        remain += nums[i];
        backtrack(nums, i + 1, remain);
        remain -= nums[i];
    }

    @Test
    public void test() {
        int[] nums = {1, 3, 1, 4, 2};
        int[] temp = {1, 1, 1, 1, 1};
        System.out.println(findTargetSumWays(temp, 3));
    }
}
