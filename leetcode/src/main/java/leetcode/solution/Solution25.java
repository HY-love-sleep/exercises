package leetcode.solution;

import org.junit.Test;

import java.util.*;

public class Solution25 {
    Map<Character, Integer> ori = new HashMap<>();
    Map<Character, Integer> cnt = new HashMap<>();

    public String minWindow(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        // ori 初始化
        for (int i = 0; i < tLen; i++) {
            ori.put(t.charAt(i), ori.getOrDefault(t.charAt(i), 0) + 1);
        }

        int l = 0, r = -1; // [l, r]
        int ansL = -1, ansR = -1; // 记录结果边界；
        int minLen = Integer.MAX_VALUE; // 窗口大小

        while (r < sLen) {
            r++;
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < minLen) {
                    ansL = l;
                    ansR = r;
                    minLen = r - l + 1;
                }
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                l++;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR + 1);
    }

    public boolean check() {
        for (Map.Entry<Character, Integer> entry : ori.entrySet()) {
            Character key = entry.getKey();
            Integer val = entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) return false;
        }
        return true;
    }

    @Test
    public void test() {
        String s = "sbcdefg";
        System.out.println(s.substring(0, 3));
    }
}
