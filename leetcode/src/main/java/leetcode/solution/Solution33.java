package leetcode.solution;

import org.junit.Test;

public class Solution33 {
    public boolean isTrue(String str) {
        boolean f1 = false, f2 = false, f3 = false, f4 = false;
        if (str.length() < 8) return false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c > '0' && c < '9') f1 = true;
            else if(c > 'a' && c < 'z') f2 = true;
            else if(c > 'A' && c < 'Z') f3 = true;
            else f4 = true;
        }
        return f1 && f2 && f3 && f4;
    }

    @Test
    public void test() {
        String pass1 = "askdhs1^";
        String pass2 = "Hy12345678...";
        System.out.println(isTrue(pass1));
        System.out.println(isTrue(pass2));
    }
}
