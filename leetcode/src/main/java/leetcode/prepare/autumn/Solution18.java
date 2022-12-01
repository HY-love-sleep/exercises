package leetcode.prepare.autumn;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：hongyan
 * @date ：Created in 2022/6/18 16:15
 * @description：猜数字游戏
 */
public class Solution18 {
    public String getHint(String secret, String guess) {
        int len = secret.length();
        int[] a = new int[10], b = new int[10];
        int bulls = 0, cows = 0;
        for (int i = 0; i < len; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                a[secret.charAt(i) - '0'] += 1;
                b[guess.charAt(i) - '0'] += 1;
            }
        }
        for (int i = 0; i < 10; i++) {
            cows += Math.min(a[i], b[i]);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bulls);
        sb.append("A");
        sb.append(cows);
        sb.append("B");
        return sb.toString();
    }

    @Test
    public void test() {
        String A = "1807";
        String B = "7810";
        System.out.println(getHint(A, B));
    }
}
