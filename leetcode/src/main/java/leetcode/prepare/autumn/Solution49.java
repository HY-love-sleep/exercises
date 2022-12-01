package leetcode.prepare.autumn;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/20 21:47
 * @description：丑数
 */
public class Solution49 {
    public int nthUglyNumber(int n) {
        int[] factors = {2, 3, 5};
        Set<Long> seen = new HashSet<>(n);
        PriorityQueue<Long> heap = new PriorityQueue<>(n);
        seen.add(1L);
        heap.offer(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long cur = heap.poll();
            ugly = (int) cur;
            for (int factor : factors) {
                long next = factor * cur;
                if (seen.add(next)) {
                    heap.add(next);
                }
            }
        }
        return ugly;
    }
}
