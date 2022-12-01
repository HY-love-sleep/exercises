package leetcode.solution;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

//柱形图中最大矩形
public class Solution21 {

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] nums = new int[len + 2];
        System.arraycopy(heights, 0, nums, 1, len);
        int area = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.offerLast(0);
        for (int i = 1; i < len + 2; i++) {
            while (nums[stack.peekLast()] > nums[i]) {
                int height = nums[stack.pollLast()];
                int width = i - stack.peekLast() - 1;
                area = Math.max(area, width * height);
            }
            stack.offerLast(i);
        }
        return area;
    }
    @Test
    public void test() {
        int[] heights = {2, 1, 5, 6, 2, 3};
//        int[] heights = {2, 0, 2};
        System.out.println(largestRectangleArea(heights));
    }
}
