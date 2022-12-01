package leetcode.prepare.autumn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/25 23:07
 * @description：和为s的连续正数序列
 */
public class Solution57_II {
    public int[][] findContinuousSequence(int target) {
        int i = 1, j = 2;
        List<int[]> res = new ArrayList<>();
        while (i < j) {
            int s = (i + j) * (j - i + 1) / 2;
            if (s == target) {
                int[] temp = new int[j - i + 1];
                for (int k = i; k <= j; k++) {
                    temp[k - i] = k;
                }
                res.add(temp);
                i++;
            } else if (s > target) {
                i++;
            } else {
                j++;
            }
        }
        return res.toArray(new int[0][]);
    }

    @Test
    public void test() {
        System.out.println(Arrays.deepToString(findContinuousSequence(15)));
    }
}
