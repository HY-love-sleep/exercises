package leetcode.solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution50 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> combine = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int index) {
        if (index == candidates.length) {
            return;
        }

        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }

        // 跳过当前数
        dfs(candidates, target, ans, combine, index + 1);
        // 选取当前数
        if (target - candidates[index] >= 0) {
            combine.add(candidates[index]);
            dfs(candidates, target - candidates[index], ans, combine, index);
            combine.remove(combine.size() - 1);
        }


    }

    @Test
    public void test() {
        int[] candidates = {2, 3, 6, 7};
        System.out.println(combinationSum(candidates, 7));
    }
}
