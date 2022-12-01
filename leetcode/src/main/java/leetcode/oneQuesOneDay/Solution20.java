package leetcode.oneQuesOneDay;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/9 22:49
 * @description：判断括号串是否有效
 */
public class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        if (n <= 1 || (n % 2) == 1) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && leftOf(c) == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private char leftOf(char c) {
        if (')' == c) {
            return '(';
        } else if (']' == c) {
            return '[';
        }
        return '{';
    }
}
