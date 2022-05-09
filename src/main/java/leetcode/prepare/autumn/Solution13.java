package leetcode.prepare.autumn;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：hongyan
 * @date ：Created in 2022/5/8 12:43
 * @description：机器人的运动范围
 */
public class Solution13 {
    int m, n, k;
    int[][] visit;

    public int movingCount(int m, int n, int k) {
        this.visit = new int[m][n];
        this.m = m;
        this.n = n;
        this.k = k;
        return dfs(0, 0, 0, 0);
    }

    private int dfs(int i, int j, int si, int sj) {
        // 不符合条件返回上层
        if (i < 0 || i >= m || j < 0 || j >= n || (si + sj) > k || visit[i][j] == 1) {
            return 0;
        }
        // 符合条件， 进行访问， 将该位置标记为已到达， 就不会重复计算
        visit[i][j] = 1;
        int right = dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
        int down = dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj);
        return 1 + right + down;
    }

    private int movingCountBfs(int m, int n, int k) {
        boolean[][] visit = new boolean[m][n];
        int res = 0;
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0, 0, 0, 0});
        while (!que.isEmpty()) {
            int[] x = que.poll();
            int i = x[0], j = x[1], si = x[2], sj = x[3];
            if (i < 0 || i >= m || j < 0 || j >= n || visit[i][j] || (si + sj) > k) {
                continue;
            }
            visit[i][j] = true;
            res++;
            que.add(new int[]{i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj});
            que.add(new int[]{i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8});
        }
        return res;
    }
}

