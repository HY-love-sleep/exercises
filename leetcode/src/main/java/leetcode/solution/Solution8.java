package leetcode.solution;

import org.junit.Test;

public class Solution8 {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public int lengthOfLIS2(int[] nums) {
        if (nums.length == 0) return 0;
        int ans = 0;
        int[] tails = new int[nums.length];
        for (int num : nums) {
            int i = 0, j = ans;
            while (i < j) {
                int m = (i + j) >> 1;
                if (num > tails[m]) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            tails[i] = num;
            if (ans == j) ans += 1;
        }
        return ans;
    }

    public int[] lisArray(int[] nums) {
//        int[] tails = new int[nums.length];
//        int[] p = new int[nums.length];
//        int len = 1;
//        p[0] = 1;
//        tails[0] = nums[0];
        int[] tails = new int[nums.length];
        tails[0] = nums[0];
        int len = 1;
        int[] p = new int[nums.length];
        p[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > tails[len - 1]) {
                tails[len] = nums[i];
                p[i] = len + 1;
                len++;
            } else {
                int l = 0, r = len - 1;
                while (l <= r) {
                    int m = (l + r) >> 1;
                    if (tails[m] == nums[i]) {
                        l = m;
                    } else if (tails[m] > nums[i]) {
                        r = m - 1;
                    } else {
                        l = m + 1;
                    }
                }
                tails[l] = nums[i];
                p[i] = l + 1;
            }
        }
        int[] res = new int[len];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (p[i] == len) {
                res[--len] = nums[i];
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS2(nums));
    }
}
