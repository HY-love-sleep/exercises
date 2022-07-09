package leetcode.prepare.autumn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/7 22:18
 * @description：包含min函数的栈
 */
public class Solution30 {
    private Deque<Integer> xStack;
    private Deque<Integer> minStack;
    public Solution30() {
        xStack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }
    public void push(int x) {
        xStack.push(x);
        minStack.push(x < minStack.peek() ? x : minStack.peek());
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
