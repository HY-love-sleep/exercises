package leetcode.solution;

import org.junit.Test;

public class Solution48 {
    public int mergeCnt(int[] nums, int left, int mid, int right, int[] temp) {
        int count = 0;
        System.arraycopy(nums, 0, temp, 0, nums.length);
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j++];
            } else if (j == right + 1) {
                nums[k] = temp[i++];
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i++];
            } else {
                nums[k] = temp[j++];
                count += (mid - i + 1);
            }
        }
        return count;
    }

    public int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) return 0;
        int mid = (left + right) >> 1;
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);
        if (nums[mid] <= nums[mid + 1]) return leftPairs + rightPairs;
        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len < 2) return 0;
        int[] temp = new int[len];
        int[] copy = new int[len];
        System.arraycopy(nums, 0, copy, 0, len);
        return reversePairs(copy, 0, len - 1, temp);
    }

    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;

        int count = 0;
        for (int k = left; k <= right; k++) {

            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }

    @Test
    public void test() {
        int[] nums = {1,2,3,4,5,6,7,0};
        int[] temp = new int[nums.length];
        System.out.println(mergeCnt(nums, 0, 3, 7, temp));
//        System.out.println(mergeAndCount(nums, 0, 3, 7, temp));
//        System.out.println(reversePairs(nums));
    }
}
