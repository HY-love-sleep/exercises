package leetcode.prepare.autumn;

import org.junit.Test;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/12 23:15
 * @description：数组中出现次数超过一半的数字
 */
public class Solution39 {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int res = nums[0];
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == res) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    res = nums[i];
                    count = 1;
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int[] nums1 = {3, 2, 3};
        System.out.println(majorityElement(nums1));
    }
}
