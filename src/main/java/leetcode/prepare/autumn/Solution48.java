package leetcode.prepare.autumn;

import java.util.HashMap;
import java.util.Map;

public class Solution48 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n <= 0) {
            return n;
        }
        Map<Character, Integer> dic = new HashMap<>(n);
        int right = 0;
        int tmp = 0;
        int ans = 0;
        while (right < n) {
            int left = dic.getOrDefault(s.charAt(right), -1);
            dic.put(s.charAt(right), right);
            if ((right - left) > tmp) {
                tmp += 1;
            } else {
                tmp = right - left;
            }
            ans = Math.max(tmp, ans);
            right++;
        }
        return ans;
    }

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int ans = 0;
        int tmp = 0;
        Map<Character, Integer> dic = new HashMap<>(n);
        for (int right = 0; right < n; right++) {
            int left = dic.getOrDefault(s.charAt(right), -1);
            dic.put(s.charAt(right), right);
            tmp = tmp >= right - left ? right - left : tmp + 1;
            ans = Math.max(tmp, ans);
        }
        return ans;
    }
}
