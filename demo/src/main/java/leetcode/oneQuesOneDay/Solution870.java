package leetcode.oneQuesOneDay;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author ：hongyan
 * @date ：Created in 2022/10/8 15:22
 * @description：田忌赛马
 */
public class Solution870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        // 田忌的马升序排列
        Arrays.sort(nums1);
        // 齐王的马降序排列
        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (int i = 0; i < nums2.length; i++) {
            heap.offer(new int[]{i, nums2[i]});
        }
        int left = 0, right = nums1.length - 1;
        while(!heap.isEmpty()) {
            int[] tmp = heap.poll();
            int idx = tmp[0];
            int maxVal = tmp[1];
            if (nums1[right] > maxVal) {
                // 比得过， 硬刚
                ans[idx] = nums1[right];
                right--;
            } else {
                // 比不过， 拿最菜的送人头
                ans[idx] = nums1[left];
                left++;
            }
        }
        return ans;
    }
}
