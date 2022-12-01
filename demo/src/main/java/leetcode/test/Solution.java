package leetcode.test;

import org.junit.Test;

import java.util.*;


public class Solution {
    Map<Character, Integer> ori = new HashMap<>();
    Map<Character, Integer> cnt = new HashMap<>();
    public String minWindow (String S, String T) {
        // write code here
        int sLen = S.length(), tLen = T.length();
        for (int i = 0; i < tLen; i++) {
            ori.put(T.charAt(i), ori.getOrDefault(T.charAt(i), 0) + 1);
        }
        int ansL = -1, ansR = -1, minLen = Integer.MAX_VALUE;
        int l = 0, r = -1;
        while (r < sLen) {
            r++;
            if (r < sLen && ori.containsKey(S.charAt(r))) {
                cnt.put(S.charAt(r), cnt.getOrDefault(S.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1< minLen) {
                    minLen = r - l + 1;
                    ansL = l;
                    ansR = r;
                }
                if (ori.containsKey(S.charAt(l))) {
                    cnt.put(S.charAt(l), cnt.getOrDefault(S.charAt(l), 0) - 1);
                }
                l++;
            }
        }
        return ansL == -1 ? "" : S.substring(ansL, ansR + 1);
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
        String S = "XDOYEZODEYXNZ";
        String T = "XYZ";
        System.out.println(minWindow(S, T));
    }
}