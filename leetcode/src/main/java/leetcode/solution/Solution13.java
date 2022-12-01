package leetcode.solution;

import org.junit.Test;

import java.util.Stack;

//接雨水
public class Solution13 {
    //动态规划
    public int trap1(int[] height) {
        int len = height.length;
        if (len <= 2) return 0;
        int ans = 0;
        int[] max_left_val = new int[len], max_right_val = new int[len];
        int max_left = 0, max_right = 0;
        for (int i = 0; i < len; i++) {
            max_left = Math.max(max_left, height[i]);
            max_left_val[i] = max_left;
        }
        for (int j = len - 1; j > -1; j--) {
            max_right = Math.max(max_right, height[j]);
            max_right_val[j] = max_right;
        }
        for (int k = 1; k < len - 1; k++) {
            int water = Math.min(max_left_val[k], max_right_val[k]) - height[k];
            ans += Math.max(water, 0);
        }
        return ans;
    }

    //栈
    public int trap2(int[] height) {
        int len = height.length;
        if (len <= 2) return 0;
        int ans = 0;
        Stack<Integer> stack = new Stack<>();  //单调递减栈
        int i = 0;
        while (i < len) { //从左往右依次遍历
            while (!stack.empty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) break;
                int width = i - stack.peek() - 1;
                int water_height = Math.min(height[i], height[stack.peek()]) - height[top];
                ans += width * water_height;
            }
            stack.push(i++);
        }
        return ans;
    }

    // 双指针
    public int trap3(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0, max_left = 0, max_right = 0;
        while (l < r) {
            if (height[l] <= height[r]) {
                if (height[l] >= max_left) {
                    max_left = height[l];
                } else {
                    ans += max_left - height[l];
                }
                l++;
            } else {
                if (height[r] >= max_right) {
                    max_right = height[r];
                } else {
                    ans += max_right - height[r];
                }
                r--;
            }
        }
        return ans;
    }

    @Test
    public void test() {
        int[] nums = {3, 1, 2, 5, 2, 4};
        int[] nums1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap3(nums1));
    }
}
