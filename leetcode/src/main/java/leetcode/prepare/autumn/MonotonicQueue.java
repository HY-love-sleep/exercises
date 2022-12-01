package leetcode.prepare.autumn;

import java.util.LinkedList;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/28 22:35
 * @description：单调队列
 */
public class MonotonicQueue {
    private LinkedList<Integer> maxQue = new LinkedList<>();

    public void pop(int n) {
        if (maxQue.getFirst() == n) {
            maxQue.pollFirst();
        }
    }

    public int getMax() {
        return maxQue.getFirst();
    }

    public void push(int x) {
        while (!maxQue.isEmpty() && x > maxQue.peekLast()) {
            maxQue.pollLast();
        }
        maxQue.offerLast(x);
    }
}
