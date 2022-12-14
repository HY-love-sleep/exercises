package leetcode.solution;

import org.junit.Test;

public class Solution20 {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matched(s, p, i, j - 1)) {
                        f[i][j] = f[i - 1][j] || f[i][j - 2];
                    }
                } else {
                    if (matched(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    } else {
                        f[i][j] = false;
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matched(String s, String p, int i, int j) {
        if (i == 0) return false;
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }


    @Test
    public void test() {
        System.out.println(isMatch("a", "aa"));
    }
}
