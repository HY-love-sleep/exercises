package leetcode.prepare.autumn;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/1 23:21
 * @description：不用加减乘除做加法
 */
public class Solution65 {
    public int add(int a, int b) {
        if (a == 0 || b == 0) {
            return a == 0 ? b : a;
        }
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return add(sum, carry);
    }
}
