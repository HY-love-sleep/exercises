package leetcode.prepare.autumn;

import org.junit.Test;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/25 22:42
 * @description：在排序数组中查找数字I
 */
public class Solution53_I {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int i = 0, j = n - 1;
        // 查找右边界right
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (nums[m] == target) {
                i = m + 1;
            } else if (nums[m] > target) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        int right = i;
        if (j >= 0 && nums[j] != target) {
            return 0;
        }
        // 查找左边界left【0, j】
        i = 0;
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (nums[m] == target) {
                j = m - 1;
            } else if (nums[m] > target) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        int left = j;
        return right - left - 1;
    }

    public int searchTest(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int i = 0, j = n - 1;
        // 二分查找右边界right
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (nums[m] == target) {
                i = m + 1;
            } else if (nums[m] < target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        if (j >= 0 && nums[j] != target) {
            return 0;
        }
        int right = i;
        // 二分查找左边界left
        i = 0;
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (nums[m] == target) {
                j = m - 1;
            } else if (nums[m] < target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        int left = j;
        return right - left - 1;
    }

    @Test
    public void test() {
        int[] nums = {5, 7, 8, 8, 8, 9};
//        int[] nums = {1};
        System.out.println(searchTest(nums, 8));
    }
}
