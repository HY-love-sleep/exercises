package leetcode.solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Solution49 {
    public List<Integer> findDuplicates(int[] nums) {
        int len = nums.length;
        List<Integer> ans = new ArrayList<>();

        if (len == 0) return ans;
        int i = 0;
        while (i < len) {
            if (nums[i] == (i + 1)) {
                i++;
//                continue;
            } else {
                if (nums[i] == nums[nums[i] - 1]) {
                    ans.add(nums[i]);
                    i++;
                } else {
                    swap(nums, i, nums[i] - 1);
                }
            }
        }
        Set<Integer> set = new HashSet<>(ans);
        return new ArrayList<>(set);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    @Test
    public void test() {
        int[] nums = {5, 4, 6, 7, 9, 3, 10, 9, 5, 6};
        System.out.println(findDuplicates(nums));
    }

}
