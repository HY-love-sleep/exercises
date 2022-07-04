package leetcode.prepare.autumn;

import org.junit.Test;

/**
 * @author ：hongyan
 * @date ：Created in 2022/5/17 16:37
 * @description：二进制中1的个数
 */
public class Solution15 {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }
    @Test
    public void test() {
        System.out.println(hammingWeight(5));
    }
}
