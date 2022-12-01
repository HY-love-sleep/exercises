package leetcode.solution;

import org.junit.Test;

public class Solution28 {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        if (l == r) return nums[0];
        while (l < r) {
            int m = (l + r) >> 1;
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return nums[l];
    }

    @Test
    public void test() {
        int[] nums = {3, 1, 2};
        System.out.println(findMin(nums));
    }
}
