package leetcode.prepare.autumn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/28 23:13
 * @description：solutionTest
 */
public class Solution {
    class MonotoneQue {
        private LinkedList<Integer> maxQue = new LinkedList<>();

        public void push(int x) {
            while (!maxQue.isEmpty() && x > maxQue.peekLast()) {
                maxQue.pollLast();
            }
            maxQue.offerLast(x);
        }

        public void pop (int n) {
            if (maxQue.getFirst() == n) {
                maxQue.pollFirst();
            }
        }

        public int getMax() {
            return maxQue.getFirst();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return new int[0];
        }

        MonotoneQue que = new MonotoneQue();

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i < k - 1) {
                que.push(nums[i]);
            } else {
                que.push(nums[i]);
                res.add(que.getMax());
                que.pop(nums[i - k + 1]);
            }

        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    @Test
    public void test() {
        int[] nums = {-7, -8, 7,5,7,1,6,0};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 4)));
    }
}
