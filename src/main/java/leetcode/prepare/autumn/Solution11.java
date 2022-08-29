package leetcode.prepare.autumn;

import org.junit.Test;

public class Solution11 {
    public int minArray(int[] numbers) {
        if (numbers.length <= 0) {
            return -1;
        }
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (numbers[mid] > numbers[right]) {
                // 如果大于右端点， 最小值在其右边
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                right -= 1;
            }
        }
        return numbers[left];
    }

    @Test
    public void test() {
        int[] nums = {4, 1, 2, 7};
        System.out.println(minArray(nums));
    }
}
