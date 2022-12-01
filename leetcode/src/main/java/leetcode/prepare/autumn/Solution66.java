package leetcode.prepare.autumn;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/2 22:10
 * @description：构建乘积数组
 */
public class Solution66 {
    public int[] constructArr(int[] a) {
        int n = a.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * a[i - 1];
        }
        int temp = 1;
        for (int j = n - 1; j >= 1; j--) {
            temp *= a[j];
            res[j - 1] *= temp;
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(constructArr(nums)));
    }
}
