package leetcode.solution;

import org.junit.Test;

import java.util.Locale;

public class Solution30 {
    public int count(String str, String s) {
        str = str.toLowerCase();
        s = s.toLowerCase();
        return str.length() - str.replaceAll(s, "").length();
    }

    @Test
    public void test() {
        String str = "ABCabc";
        String s = "A";
        System.out.println(count(str, s));
    }
}
