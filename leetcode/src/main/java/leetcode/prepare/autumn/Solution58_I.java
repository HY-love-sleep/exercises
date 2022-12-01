package leetcode.prepare.autumn;

import org.junit.Test;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/30 16:44
 * @description：反转单词顺序
 */
public class Solution58_I {
    public String reverseWords(String s) {
        s = s.trim();
        int i = s.length() - 1, j = i;
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            sb.append(s, i + 1, j + 1).append(" ");
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }
        return sb.toString().trim();
    }

    @Test
    public void test() {
        String s = "i can pass the test";
        System.out.println(reverseWords(s));
    }
}
