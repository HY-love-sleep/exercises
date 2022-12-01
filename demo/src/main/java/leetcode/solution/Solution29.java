package leetcode.solution;

import org.junit.Test;

public class Solution29 {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = (l + r) >> 1;
            if (nums[m] < nums[r]) {
                r = m;
            } else if (nums[m] > nums[r]){
                l = m + 1;
            } else {
                r--;
            }
        }
        return nums[l];
    }

    @Test
    public void test() {
//        int[] nums = {2,2,2,0,1};
        int[] nums = {3, 3, 1, 3};
        System.out.println(findMin(nums));
    }
}
