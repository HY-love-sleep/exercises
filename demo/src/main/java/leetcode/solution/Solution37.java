package leetcode.solution;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Solution37 {
    public int count(int[] nums) {
        Set<Integer> set = new HashSet<>();
        set.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                nums[i] = nums[i - 1] + 1;
                set.add(nums[i]);
            } else if (nums[i] < nums[i - 1]) {
                nums[i] = nums[i - 1];
            } else {
                set.add(nums[i]);
            }
        }
        return set.size();
    }


    @Test
    public void test() {
//        testSort();
        int[] nums = {1, 2, 2, 2, 2, 3};
        System.out.println(count(nums));
    }
}
