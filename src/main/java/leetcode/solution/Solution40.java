package leetcode.solution;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Solution40 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        // Remove duplication
        for (int num : nums) {
            numSet.add(num);
        }

        int ans = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentLen = 1;
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentLen += 1;
                }
                ans = Math.max(ans, currentLen);
            }
        }

        return ans;
    }

    @Test
    public void test() {
        int[] nums = {100, 4, 200, 1, 3, 4, 2};
        System.out.println(longestConsecutive(nums));
    }

}
