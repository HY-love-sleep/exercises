import org.junit.Test;

import java.util.*;

/**
 * 两个正序数组的中位数
 */
public class Solution {
    int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(text1, 0, text2, 0);
    }

    public int dp(String s1, int i, String s2, int j) {
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = 1 + dp(s1, i + 1, s2, j + 1);
        } else {
            memo[i][j] = Math.max(
                    dp(s1, i + 1, s2, j),
                    dp(s1, i, s2, j + 1)
            );
        }
        return memo[i][j];
    }
}