package leetcode.solution;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution46 {
    public String reverseParentheses(String s) {
        StringBuffer sb = new StringBuffer();
        Deque<String> stack= new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.offerLast(sb.toString());
                sb.setLength(0);
            } else if (ch == ')') {
                sb.reverse();
                sb.insert(0, stack.pollLast());
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }


    @Test
    public void test() {
        String s = "(u(love)i)";
        System.out.println(reverseParentheses(s));
    }
}
