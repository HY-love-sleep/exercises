package leetcode.oneQuesOneDay;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：hongyan
 * @date ：Created in 2022/10/9 18:45
 * @description：字符串的排列
 */
public class Solution567 {
    /**
     * 判断s1的排列之一是否是s2的子串
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        int left = 0, right = 0;
        int valid = 0;
        for (char ch : s1.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }
                char d = s2.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }

    @Test
    public void test() {
        String s1 = "ab";
        String s2 = "eidbaooo";
        String s3 = "eidboaoo";
        String s4 = "hello";
        String s5 = "ooolleoooleh";
        String s6 = "acb";
//        System.out.println(checkInclusion(s1, s2));
//        System.out.println(checkInclusion(s1, s3));
//        System.out.println(checkInclusion(s4, s5));
        System.out.println(checkInclusion(s1, s6));
    }
}
