package leetcode.prepare.autumn;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/27 18:24
 * @description：数组中数字出现的次数 里除两个数字之外，其他数字都出现了两次
 */
public class Solution56_I {
    public int[] singleNumbers(int[] nums) {
        int z = 0;
        for (int num : nums) {
            z ^= num;
        }
        // z = x ^ y;

        int m = 1;
        while ((z & m) == 0) {
            m <<= 1;
        }

        int x = 0, y = 0;
        for (int num : nums) {
            if ((num & m) == 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }
        return new int[]{x, y};
    }
}
