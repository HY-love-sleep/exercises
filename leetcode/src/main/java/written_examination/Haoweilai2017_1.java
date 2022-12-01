package written_examination;

import org.junit.Test;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/20 15:56
 * @description：找出s中连输最长的数字串
 */
public class Haoweilai2017_1 {
    public static String longestNumStr(String s) {
        // 找出s中连输最长的数字串
        int start = 0, end = 0;
        int maxLen = 0;
        int i = 0, j = 0;
        while (i <= j && j < s.length()) {
            char ch = s.charAt(j);
            if (ch >= '0' && ch <= '9') {
                j++;
                if ((j - i) > maxLen) {
                    maxLen = j - i;
                    start = i;
                    end = j;
                }
            } else {
                i = j;
                j++;
            }
        }
        return s.substring(start + 1, end);
    }

    public static String longestNumStr2(String s) {
        // 找出s中连输最长的数字串
        int max = 0, count = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                count++;
                if (count > max) {
                    max = count;
                    end = i;
                }
            } else {
                count = 0;
            }
        }
        return s.substring(end - max + 1, end + 1);
    }

    @Test
    public void test() {
        String s = "abcd12345ed125ss123456789";
        System.out.println(longestNumStr2(s));
    }
}
