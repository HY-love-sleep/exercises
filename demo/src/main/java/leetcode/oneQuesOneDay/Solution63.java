package leetcode.oneQuesOneDay;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/23 16:16
 * @description：不同路径
 */
public class Solution63 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][]dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], 1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    if (i == 0) {
                        for (int p = j + 1; p < n; p++) {
                            dp[0][p] = 0;
                        }
                    }
                    if (j == 0) {
                        for (int q = i + 1; q < m; q++) {
                            dp[q][0] = 0;
                        }
                    }
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j] == 0 ? 0 : dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] nums = {{0,0,0},{0, 1, 0}, {0,0,0}};
        System.out.println(uniquePathsWithObstacles(nums));
    }
}
