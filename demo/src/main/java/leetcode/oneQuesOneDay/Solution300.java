package leetcode.oneQuesOneDay;

import java.util.Arrays;

/**
 * @author ：hongyan
 * @date ：Created in 2022/10/10 17:55
 * @description：最长递增子序列
 */
public class Solution300 {
    /**
     * dp[i] : 以nums[i]结尾的最长递增子序列的长度
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int ans = 1;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
