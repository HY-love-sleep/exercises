package leetcode.prepare.autumn;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/27 18:31
 * @description：数组中数字出现的次数 II  中除一个数字只出现一次之外，其他数字都出现了三次
 */
public class Solution56_II {
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                counts[i] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= (counts[31 - i] % 3);
        }
        return res;
    }
}
