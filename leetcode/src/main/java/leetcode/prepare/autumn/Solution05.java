package leetcode.prepare.autumn;

import org.junit.Test;

public class Solution05 {
    public String replaceSpace(String s) {
        int len = s.length();
        char[] chars = new char[len * 3];
        int size = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ') {
                chars[size++] = '%';
                chars[size++] = '2';
                chars[size++] = '0';
            } else {
                chars[size++] = s.charAt(i);
            }
        }
        String res = new String(chars, 0, size);
        return res;
    }

    public String replace_space(String s) {
        String res = s.replaceAll(" ", "%20");
        return res;
    }

    @Test
    public void test() {
        String str  = "We are happy.";
        System.out.println(replaceSpace(str));
    }
}
