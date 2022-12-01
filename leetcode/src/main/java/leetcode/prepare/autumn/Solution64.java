package leetcode.prepare.autumn;

import org.junit.Test;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/31 15:13
 * @description：求1+2+…+n
 */
public class Solution64 {
    public int sumNums(int n) {
        if (n == 1) {
            return 1;
        }
        n += sumNums(n - 1);
        return n;
    }

    public int sumNums2(int n) {
        boolean x = n > 1 && (n += sumNums2(n - 1)) > 0;
        return n;
    }

    @Test
    public void test() {
        System.out.println(sumNums2(5));
    }
}
