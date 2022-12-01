package leetcode.utils;

import org.junit.Test;

public class HexToDecimal {
    // 十六进制转十进制输出
    public long getDecimal(String hex) {
        hex = hex.substring(2);
        char[] c = hex.toCharArray();
        int n = c.length;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (c[i] == 'a') ans += 10 * Math.pow(16, n - i - 1);
            if (c[i] == 'b') ans += 11 * Math.pow(16, n - i - 1);
            if (c[i] == 'c') ans += 12 * Math.pow(16, n - i - 1);
            if (c[i] == 'd') ans += 13 * Math.pow(16, n - i - 1);
            if (c[i] == 'e') ans += 14 * Math.pow(16, n - i - 1);
            if (c[i] == 'f') ans += 15 * Math.pow(16, n - i - 1);
            else {
                ans += (c[i] - '0') * Math.pow(16, n - i - 1);
            }
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(getDecimal("Oxfff"));
    }
}
