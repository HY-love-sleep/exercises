package leetcode.solution;

import org.junit.Test;

public class Solution22 {
    public String compressString(String S) {
        int pre_len = S.length();
        StringBuilder sb = new StringBuilder();
        char preC = ' ';
        int count = 0;
        for (int i = 0; i < pre_len; i++) {
            char c = S.charAt(i);
            if (c == preC) {
                count++;
            } else {
                sb.append(preC);
                sb.append(count);
                count = 1;
                preC = c;
            }
        }
        sb.append(preC);
        sb.append(count);
        String s = sb.substring(2);
        if (s.length() < pre_len) return s;
        return S;
    }

    @Test
    public void test() {
        String s = "aabcccccaaa";
        System.out.println(compressString(s));
    }
}
