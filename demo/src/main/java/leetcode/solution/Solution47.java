package leetcode.solution;

import org.junit.Test;

public class Solution47 {
    public String check(String str) {
        StringBuffer sb = new StringBuffer(str);
        for (int i = 0; i < sb.length(); i++) {
            if ((i + 2) < sb.length() && sb.charAt(i) == sb.charAt(i + 1) && sb.charAt(i) == sb.charAt(i + 2)) {
                sb.setCharAt(i, ' ');
            }
            if ((i + 3) < sb.length() && sb.charAt(i) == sb.charAt(i + 1) && sb.charAt(i + 2) == sb.charAt(i + 3)) {
                sb.setCharAt(i + 2, ' ');
            }
        }
//        System.out.println(sb);
        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != ' ') {
                ans.append(sb.charAt(i));
            }
        }
        return ans.toString();
    }

    @Test
    public void test() {
        String s = "helloo";
        String s1 = "wooooooow";
        System.out.println(check(s1));
    }
}
