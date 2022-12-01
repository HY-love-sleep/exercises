package leetcode.solution;

import org.junit.Test;

public class Solution6 {
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int a = centre(s, i, i);
            int b = centre(s, i, i+ 1);
            int c = Math.max(a, b);
            if (c > end - start + 1) {
                start = i - (c - 1) / 2;
                end = i + c / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int centre(String s, int left, int right) {
        while (left <= right && left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    @Test
    public void test() {
        String s = "ccc";
        System.out.println(longestPalindrome(s));
    }
}
