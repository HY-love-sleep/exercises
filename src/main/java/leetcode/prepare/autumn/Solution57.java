package leetcode.prepare.autumn;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/30 16:25
 * @description：和为s的两个数字
 */
public class Solution57 {
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            if (nums[i] + nums[j] == target) {
                return new int[]{nums[i], nums[j]};
            } else if (nums[i] + nums[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[0];
    }

    @Test
    public void test() {
        int[] nums = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }
}
