package leetcode.solution;

import org.junit.Test;

public class Solution55 {

    int ans= 0;
    public int fun(int[][] nums) {
        boolean[][] left = new boolean[nums.length][nums[0].length];
        boolean[][] up = new boolean[nums.length][nums[0].length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                left[i][j] = true;
                up[i][j] = true;
            }
        }

        dfs(nums, 0, 0, left, up);
        return ans;
    }

    public void dfs(int[][] nums, int i, int j, boolean[][] left, boolean[][] up) {
        if (i < 0 || j < 0 || i >= nums.length || j >= nums[0].length) return;

        if (i == (nums.length - 1) && j == (nums[0].length - 1)) {
            ans++;
            return;
        }
        dfs(nums, i + 1, j, left, up);
        dfs(nums, i, j + 1, left, up);
        if (left[i][j] && i != nums.length - 1 && j != nums[0].length - 1) {
            left[i][j] = false;
            dfs(nums, i - 1, j, left, up);
        }

        if (up[i][j] && i != nums.length - 1 && j != nums[0].length - 1) {
            up[i][j] = false;
            dfs(nums, i, j - 1, left, up);
        }
    }

    @Test
    public void test() {
        int[][] nums = new int[3][3];
        System.out.println(fun(nums));
    }
}
