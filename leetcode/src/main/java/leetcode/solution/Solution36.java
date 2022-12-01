package leetcode.solution;

public class Solution36 {
    public int numSubmat(int[][] mat) {
        // 初始化辅助数组row
        int n = mat.length, m = mat[0].length;
        int[][] row = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) row[i][j] = mat[i][0];
                else {
                    row[i][j] = mat[i][j] == 0 ? 0 : row[i][j - 1] + 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int col = row[i][j];
                for (int k = i; k >=0 && col >= 0; k--) {
                    col = Math.min(col, row[k][j]);
                    ans += col;
                }
            }
        }
        return ans;
    }
}
