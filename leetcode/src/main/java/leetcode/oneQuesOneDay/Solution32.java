package leetcode.oneQuesOneDay;

import org.junit.Test;

import java.util.Stack;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/10 09:31
 * @description：最长有效括号
 */
public class Solution32 {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int[] dp = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                dp[i + 1] = 0;
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    int left = stack.pop();
                    dp[i + 1] = i - left + 1 + dp[left];
                } else {
                    dp[i + 1] = 0;
                }
            }
        }
        for (int i = 1; i < s.length() + 1; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    @Test
    public void test() {
        String s = "))()(())(()";
        System.out.println(longestValidParentheses(s));
    }
}
