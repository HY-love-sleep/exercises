package leetcode.prepareForAutumnMoves;

import org.junit.Test;

public class Solution03 {
    public int findRepeatNumber(int[] nums) {
        int len = nums.length;
        int i = 0;
        while (i < len) {
            if (i == nums[i]) {
                i++;
            } else if (nums[i] == nums[nums[i]]) {
                return nums[i];
            } else {
                swap(nums, i, nums[i]);
            }
        }
        return -1;
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    @Test
    public void test() {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(nums));
    }
}
