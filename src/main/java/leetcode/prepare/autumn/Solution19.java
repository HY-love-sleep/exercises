package leetcode.prepare.autumn;

import org.junit.Test;

/**
 * @author ：hongyan
 * @date ：Created in 2022/6/25 16:42
 * @description：正则表达式匹配
 */
public class Solution19 {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (isMatched(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (isMatched(s, p, i, j)) {
                        f[i][j] = f[i -1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean isMatched(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        return s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.';
    }

    @Test
    public void test() {
//        String s = "mississippi";
//        String p = "mis*is*p*.";
//        System.out.println(isMatch(s, p));
        boolean[][] dp = new boolean[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println(dp[i][j]);
            }
        }
    }
}
