package leetcode.solution;

import org.junit.Test;

import java.util.HashMap;

public class Solution18 {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int left = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!window.containsKey(s.charAt(i))) {
                window.put(s.charAt(i), i);
                ans = Math.max(ans, i - left + 1);
            } else {
                if (left > window.get(s.charAt(i))) {
                    window.put(s.charAt(i), i);
                    ans = Math.max(ans, i - left + 1);
                } else {
                    left = Math.max(left, window.get(s.charAt(i)) + 1);
                    window.put(s.charAt(i), i);
                }
            }
        }
        return ans;
    }

    @Test
    public void test() {
        String s = "abcabcbb";
        String str = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring(str));
    }


}