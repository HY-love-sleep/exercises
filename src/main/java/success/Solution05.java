package success;


import org.junit.Test;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/6 14:29
 * @description：最长回文子串
 */
public class Solution05 {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int p = centerExtension(s, i, i);
            int q = centerExtension(s, i, i + 1);
            int maxLen = Math.max(p, q);
            if (maxLen > (end - start + 1)) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int centerExtension(String s, int i, int j) {
        if (i > j || i < 0 || j >= s.length()) {
            return -1;
        }
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }

    @Test
    public void test() {
        String s = "bacab";
        String g = "baccab";
        System.out.println(longestPalindrome(s));
        System.out.println(longestPalindrome(g));
    }
}
