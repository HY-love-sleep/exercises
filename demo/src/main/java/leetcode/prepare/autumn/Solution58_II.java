package leetcode.prepare.autumn;

import java.util.Locale;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/30 16:53
 * @description：左旋字符串
 */
public class Solution58_II {
    public String reverseLeftWords(String s, int n) {
        String s1 = s.substring(0, n);
        String s2 = s.substring(n);
        return s2 + s1;
    }
}
