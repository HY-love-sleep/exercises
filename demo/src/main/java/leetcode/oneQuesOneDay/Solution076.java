package leetcode.oneQuesOneDay;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/10 15:59
 * @description：数组中第k大的数字
 */
public class Solution076 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();
        return heap.peek();
    }
}
