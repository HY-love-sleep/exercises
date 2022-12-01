package leetcode.solution;

import org.junit.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Solution39 {
    List<Integer> t = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        int n = 1 << len;
        for (int i = 0; i < n; i++) {
            t.clear();
            for (int j = 0; j < len; j++) {
                if((i & (1 << j)) != 0) {
                    t.add(nums[j]);
                }
            }
            res.add(new ArrayList<>(t));
        }
        return res;
    }

    public List<List<Integer>> subSets(int[] nums) {
        recur(0, nums);
        return res;
    }

    public void recur(int cur, int[] nums) {
        if (cur == nums.length) {
            res.add(new ArrayList<>(t));
            return;
        }
        t.add(nums[cur]);
        recur(cur + 1, nums);
        t.remove(t.size() - 1);
        recur(cur + 1, nums);
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        System.out.println(subSets(nums));
    }
}
