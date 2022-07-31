package leetcode.prepare.autumn;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/31 10:42
 * @description：扑克牌中的顺子
 */
public class Solution61 {
    public boolean isStraight(int[] nums) {
        int max = -1, min = 14;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 && !set.add(nums[i])) {
                return false;
            }
            max = Math.max(max, nums[i]);
            min = nums[i] == 0 ? min : Math.min(min, nums[i]);
        }
        return (max - min) < 5;
    }

    @Test
    public void test() {
        int[] nums = {0, 0, 1, 2, 5};
        System.out.println(isStraight(nums));
    }
}
