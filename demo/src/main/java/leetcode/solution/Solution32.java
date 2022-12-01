package leetcode.solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution32 {
    public boolean isAllHappy(int m, int k, int[] nums) {
        // m颗糖分给k个人
        if (m < k) return false;
        ArrayList<ArrayList<Integer>> sugars = new ArrayList<>(k);

        Arrays.sort(nums);
        for (int i = 0; i < k; i++) {
            ArrayList<Integer> l = new ArrayList<>();
            l.add(nums[--m]);
            sugars.add(l);
        }
//        int[][] sugars = new int[k][m];

        int[] tmp = new int[k];  //保存当时每个人手里糖的快乐值
        while (m > 0) {
            int flag = 0; // 记录谁的糖最少；
            int minCount = Integer.MAX_VALUE; // 记录最少的糖
            for (int i = 0; i < k; i++) {
                tmp[i] = sum(sugars.get(i));
                if (tmp[i] < minCount) {
                    flag = i;
                    minCount = tmp[i];
                }
            }
            sugars.get(flag).add(nums[--m]);
        }
        
        int n = sum(sugars.get(0));
        for (ArrayList<Integer> sugar : sugars) {
            int t = sum(sugar);
            if (t != n) return false;
        }
        return true;
    }

    public int sum(ArrayList<Integer> nums) {
        int ans = 0;
        for (int num : nums) {
            ans += num;
        }
        return ans;
    }

    @Test
    public void test() {
//        int[] nums = {19, 19};
//        int[] nums = {1,1,1,1,1,2,10,7,1,2,3};
        int[] nums = {4,4,6,2,3,8,10,2,10,7};
        System.out.println(isAllHappy(10,4,nums));
    }
}
