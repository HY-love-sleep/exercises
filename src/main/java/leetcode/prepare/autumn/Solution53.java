package leetcode.prepare.autumn;

import org.junit.Test;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/27 14:39
 * @description：0～n-1中缺失的数字 【见到排序数组直接二分查找】
 */
public class Solution53 {
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (nums[m] == m) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }

    @Test
    public void test() {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 9};
        System.out.println(missingNumber(nums));
    }
}


