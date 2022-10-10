package leetcode.oneQuesOneDay;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：hongyan
 * @date ：Created in 2022/10/9 16:18
 * @description：最小覆盖子串
 */
public class Solution76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        int left = 0, right = 0;
        int start = 0, len = Integer.MAX_VALUE;
        int valid = 0;
        for(char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            while (valid == need.size()) {
                if (right - left < len) {
                    len = right - left;
                    start = left;
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    @Test
    public void test() {
        String s = "aa";
        String t = "aa";
        System.out.println(minWindow(s, t));
    }
}
