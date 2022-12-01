package leetcode.solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution52 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int up = 0, left = 0, down = matrix.length - 1, right = matrix[0].length - 1;
        while (up <= down && left <= right) {
            for (int i = left; i <= right; i++) {
                ans.add(matrix[up][i]);
            }
            up++;
            if (up > down) break;
            for (int i = up; i <= down; i++) {
                ans.add(matrix[i][right]);
            }
            right--;
            if (left > right) break;
            for (int i = right; i >= left; i--) {
                ans.add(matrix[down][i]);
            }
            down--;
            if (up > down) break;
            for (int i = down; i >= up && left <= right; i--) {
                ans.add(matrix[i][left]);
            }
            left++;
            if (left > right) break;
        }
        return ans;
    }

    @Test
    public void test() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(spiralOrder(matrix2));
    }
}
