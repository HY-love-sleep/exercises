package success;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/9 09:39
 * @description：剪绳子
 */

import org.junit.Test;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class Solution14_I {
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int remainder = n % 3;
        int num = n / 3;
        if (remainder == 1) {
            return (int)Math.pow(3, num - 1) * 4;
        } else if (remainder == 2) {
            return 2 * (int)Math.pow(3, num);
        }
        return (int)Math.pow(3, num);
    }

    @Test
    public void test() {
        System.out.println(cuttingRope(10));
    }
}
