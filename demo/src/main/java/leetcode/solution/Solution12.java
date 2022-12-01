package leetcode.solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution12 {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        allRange(nums, 0, nums.length, res);
        return res;
    }

    public void allRange(int[] nums, int k, int m, List<List<Integer>> res) {
        if (k == m) {
            res.add(arrayToList(nums));
        }
        for (int i = k; i < m; i++) {
            if (i != k && nums[i] == nums[k]) continue;
            swap(nums, i, k);
            allRange(nums, k + 1, m, res);
            swap(nums, i, k);
        }
    }

    // 数组转List
    public List<Integer> arrayToList(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            res.add(num);
        }
        return res;
    }

    public void swap(int[] nums, int a, int b) {
        int c = nums[a];
        nums[a] = nums[b];
        nums[b] = c;
    }

    @Test
    public void test() {
        int[] nums = {1, 1};
        System.out.println(permute(nums));
    }


}
