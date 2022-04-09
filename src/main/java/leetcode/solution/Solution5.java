package leetcode.solution;

import org.junit.Test;

import java.util.ArrayList;

public class Solution5 {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }
        int up = 0, down = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        while (up <= down && left <= right) {
            for (int i = left; i <= right; i++) {
                ans.add(matrix[up][i]);
            }
            up++;
            for (int i = up; i <= down; i++) {
                ans.add(matrix[i][right]);
            }
            right--;
            for (int i = right; i >= left && up <= down; i--) {
                ans.add(matrix[down][i]);
            }
            down--;
            for (int i = down; i >= up && left <= right; i--) {
                ans.add(matrix[i][left]);
            }
            left++;
        }
        return ans;
    }

    @Test
    public void test() {
//        int[][] matrix = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };
        int[][] matrix = {
                {2,3}
        };
        System.out.println(spiralOrder(matrix));
    }
}
