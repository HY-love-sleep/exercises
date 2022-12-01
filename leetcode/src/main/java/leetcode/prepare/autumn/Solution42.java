package leetcode.prepare.autumn;

import org.junit.Test;

public class Solution42 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }

    @Test
    public void test() {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
