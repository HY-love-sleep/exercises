package leetcode.oneQuesOneDay;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：hongyan
 * @date ：Created in 2022/10/9 19:45
 * @description：无重复字符的最长子串
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.get(d) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
