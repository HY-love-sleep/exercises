package leetcode.prepare.autumn;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/7 22:25
 * @description：栈的压入、弹出序列
 */
public class Solution31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();
        int j = 0;
        for (int k : pushed) {
            while (!stack.isEmpty() && stack.peekFirst() == popped[j]) {
                stack.pollFirst();
                j++;
            }
            stack.offerFirst(k);
        }
        while (!stack.isEmpty() && stack.peekFirst() == popped[j]) {
            stack.pollFirst();
            j++;
        }
        return stack.isEmpty();
    }

    @Test
    public void test() {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        System.out.println(validateStackSequences(pushed, popped));
    }
}
