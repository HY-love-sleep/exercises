package leetcode.solution;

import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution38 {
    public int[] buildCnt(int[] heights) {
        int len = heights.length;
        int[] front = new int[len];
        int[] back = new int[len];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            front[i] += stack.size();
            while (!stack.isEmpty() && heights[i] > stack.peekLast()) {
                stack.pollLast();
            }
            stack.push(heights[i]);
        }
        stack.clear();
        for (int i = len - 1; i >= 0; i--) {
            back[i] += stack.size();
            while (!stack.isEmpty() && heights[i] > stack.peekLast()) {
                stack.pollLast();
            }
            stack.offerLast(heights[i]);
        }

        for (int i = 0; i < len; i++) {
            front[i] += back[i] + 1;
        }
        return front;
    }

    @Test
    public void test() {
        int[] heights = {5,3,8,3,2,5};
        System.out.println(Arrays.toString(buildCnt(heights)));
    }
}
