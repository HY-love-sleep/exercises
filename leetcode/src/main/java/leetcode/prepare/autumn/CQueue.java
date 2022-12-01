package leetcode.prepare.autumn;

import java.util.ArrayDeque;
import java.util.Deque;

public class CQueue {
    Deque<Integer> stack1;
    Deque<Integer> stack2;
    public CQueue() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                return -1;
            } else {
                while (!stack1.isEmpty()) {
                    int tmp = stack1.poll();
                    stack2.push(tmp);
                }
                return stack2.poll();
            }
        } else {
            return stack2.poll();
        }
    }
}
