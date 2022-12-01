package leetcode.solution;

import org.junit.Test;

public class Solution57 {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        if (len == 0) return 0;
        int[] dp = new int[len + 1];
        for (int i = 2; i < len + 1; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }
        return dp[len];
    }

    @Test
    public void test() {
        int[] nums = {10, 15, 20};
        System.out.println(minCostClimbingStairs(nums));
    }
}
