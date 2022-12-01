package leetcode.prepare.autumn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/7 11:13
 * @description：顺时针打印矩阵
 */
public class Solution29 {
    public int[] spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return new int[0];
        }
        int n = matrix[0].length;

        int left = 0, right = n - 1;
        int up = 0, down = m - 1;
        int[] res = new int[m * n];
        List<Integer> list = new ArrayList<>();
        while (list.size() < m * n) {
            if (up <= down) {
                for (int i = left; i <= right; i++) {
                    list.add(matrix[up][i]);
                }
                up++;
            }

            if (left <= right) {
                for (int i = up; i <= down; i++) {
                    list.add(matrix[i][right]);
                }
                right--;
            }

            if (up <= down) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[down][i]);
                }
                down--;
            }

            if (left <= right) {
                for (int i = down; i >= up; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }
        for (int i = 0; i < m * n; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    @Test
    public void test() {
        int[][] nums = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[] ans = spiralOrder(nums);
        System.out.println(Arrays.toString(ans));
    }
}
