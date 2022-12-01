package leetcode.solution;

import org.junit.Test;

import java.util.*;


public class Solution2 {
    /**
     * 判断岛屿数量
     *
     * @param grid char字符型二维数组
     * @return int整型
     */

    public int solve(int[][] grid) {
        // write code here
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int[][] visit = new int[grid.length][grid[0].length];
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && visit[i][j] == 0) {
                    ans += 1;
                    dfs(grid, i, j, visit);
                }
            }
        }
        return ans;
    }

    public void dfs(int[][] grid, int r, int c, int[][] visit) {
        int row = grid.length, column = grid[0].length;
        if (r < 0 || c < 0 || r >= row || c >= column || visit[r][c] == 1 || grid[r][c] == 0) return;
        visit[r][c] = 1;
        dfs(grid, r + 1, c, visit);
        dfs(grid, r - 1, c, visit);
        dfs(grid, r, c + 1, visit);
        dfs(grid, r, c - 1, visit);
    }

    @Test
    public void test() {
        int[][] grid = {{1, 1, 0, 0, 0}, {0, 1, 0, 1, 1}, {0, 0, 0, 1, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 1, 1}};
        System.out.println(solve(grid));
    }
}
