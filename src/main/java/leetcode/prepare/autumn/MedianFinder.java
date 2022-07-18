package leetcode.prepare.autumn;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
    Queue<Integer> A, B;
    public MedianFinder() {
        // A：小顶堆， 保存较大的那半边元素
        A = new PriorityQueue<>((a, b) -> (a - b));
        // B： 大顶堆， 保存较小的那半边元素
        B = new PriorityQueue<>((a, b) -> (b - a));
    }

    public void addNum(int num) {
        if (A.size() == B.size()) {
            B.add(num);
            A.add(B.poll());
        } else {
            A.add(num);
            B.add(A.poll());
        }
    }

    public double findMedian() {
        if (A.size() == B.size()) {
            return (A.peek() + B.peek()) / 2.0;
        } else {
            return A.peek();
        }
    }
}
