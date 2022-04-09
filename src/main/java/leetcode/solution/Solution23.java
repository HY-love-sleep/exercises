package leetcode.solution;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution23 {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        Deque<Character> stack = new ArrayDeque<>();
        stack.offerLast('0');
        for (int i = 0; i < len; i++) {
            char n = num.charAt(i);

            while (!stack.isEmpty() && stack.peekLast() > n && k > 0) {
                stack.pollLast();
                k--;
            }
//            k--;
            stack.offerLast(n);
        }
        while (k > 0) {
            k--;
            stack.pollLast();
        }
        while (!stack.isEmpty() && stack.peekFirst() == '0') {
            stack.pollFirst();
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }
        return sb.toString().equals("") ? "0" : sb.toString();
    }

    @Test
    public void test() {
        String num1 = "12345264";
        String num2 = "1432219";
        String num = "9";
        System.out.println(removeKdigits(num, 1));
    }
}
