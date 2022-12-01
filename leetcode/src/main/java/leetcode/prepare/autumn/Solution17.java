package leetcode.prepare.autumn;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author ：hongyan
 * @date ：Created in 2022/5/30 18:44
 * @description：打印从1到最大的n位数
 */
public class Solution17 {
    public int[] printNumbers(int n) {
        if (n <= 0) {
            return null;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = max * 10 + 9;
        }
        int[] res = new int[max];
        for (int i = 1; i <= max; i++) {
            res[i - 1] = i;
        }
        return res;
    }

    @Test
    public void test() {
        int[] res = printNumbers(1);
        System.out.println(Arrays.toString(res));
    }
}
