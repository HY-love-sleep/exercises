package leetcode.solution;

public class Solution10 {
    public int search(int[] nums, int target) {
        return searchHelper(nums, 0, nums.length - 1, target);
    }

    public int searchHelper(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) >> 1;
        int leftValue = nums[left];
        int rightValue = nums[right];
        int midValue = nums[mid];
        if (leftValue == target) {
            return left;
        }
        if (rightValue == target) {
            return right;
        }
        if (midValue == target) {
            return mid;
        }
        if (leftValue < midValue) { //左半边有序
            if (target > leftValue && target < midValue) {
                return searchHelper(nums, left + 1, mid - 1, target);
            } else {
                return searchHelper(nums, mid + 1, right - 1, target);
            }
        } else { //右半边有序
            if (target > midValue && target < rightValue) {
                return searchHelper(nums, mid + 1, right - 1, target);
            } else {
                return searchHelper(nums, left + 1, mid - 1, target);
            }
        }
    }
}
