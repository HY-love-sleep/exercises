package leetcode.solution;

import org.junit.Test;

import java.util.*;


public class Solution44 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int findPeakElement (int[] nums) {
        // write code here
        int len = nums.length;
        int l = 0, r = len - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    @Test
    public void test() {
        int[] nums = {2, 4, 1, 2, 7, 8, 4};
        System.out.println(findPeakElement(nums));
    }
}