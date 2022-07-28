package leetcode.prepare.autumn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/28 22:45
 * @description：滑动窗口的最大值
 */
public class Solution59_I {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }

        MonotonicQueue que = new MonotonicQueue();

        for (int i = 0; i < k - 1; i++) {
            que.push(nums[i]);
        }

        List<Integer> res= new ArrayList<>();

        for (int i = k - 1; i < nums.length; i++) {
            que.push(nums[i]);
            res.add(que.getMax());
            que.pop(nums[i- k + 1]);
        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
