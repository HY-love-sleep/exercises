package leetcode.solution;

import org.junit.Test;

import java.util.Arrays;

public class Solution41 {

    public int rob(int[] nums) {
        int[] nums1 = new int[nums.length - 1];
        System.arraycopy(nums, 0, nums1, 0, nums.length - 1);

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }


    @Test
    public void test() {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(rob(nums));
    }
}