package leetcode.prepare.autumn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/30 17:38
 * @description：单调队列
 */
public class MaxQueue {
    private LinkedList<Integer> que;
    private LinkedList<Integer> monotonicQue;

    public MaxQueue() {
        que = new LinkedList<>();
        monotonicQue = new LinkedList<>();
    }

    public int max_value() {
        if (!monotonicQue.isEmpty()) {
            return monotonicQue.getFirst();
        }
        return -1;
    }

    public void push_back(int value) {
        que.offerLast(value);
        while (!monotonicQue.isEmpty() && value > monotonicQue.peekLast()) {
            monotonicQue.pollLast();
        }
        monotonicQue.offerLast(value);
    }

    public int pop_front() {
        int res = -1;
        if (!que.isEmpty()) {
            res = que.peekFirst();
            que.pollFirst();
        }
        if (res == monotonicQue.getFirst()) {
            monotonicQue.pollFirst();
        }
        return res;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
