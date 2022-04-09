package leetcode.solution;

import org.junit.Test;

import java.util.*;

public class Solution7 {

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3) return ans;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int p = i + 1, q = nums.length - 1;

            while (p < q) {
                if (nums[i] + nums[p] + nums[q] == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[p]);
                    list.add(nums[q]);
                    ans.add(list);
                    while (p < nums.length - 2 && nums[p] == nums[p + 1]) p++;
                    while (q > 0 && nums[q] == nums[q - 1]) q--;
                    p++;
                    q--;
                } else if (nums[i] + nums[p] + nums[q] < 0) {
                    p++;
                } else {
                    q--;
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        if (nums.length < 3) return ans;

        //对数组进行排序
        quickSort(nums, 0, nums.length - 1);

        //for 循环固定首位， 双指针寻找答案
        for (int i = 0; i < nums.length - 2; i++) {
            int p = i + 1, q = nums.length - 1;
            while (p < q) {
                ArrayList<Integer> list = new ArrayList<>();
                if (nums[i] + nums[p] + nums[q] == 0) {
                    list.add(nums[i]);
                    list.add(nums[p]);
                    list.add(nums[q]);
                    set.add(list);
                    p++;
                    q--;
                } else if (nums[i] + nums[p] + nums[q] < 0) {
                    p++;
                } else {
                    q--;
                }
            }
        }
        ans.addAll(set);
        return ans;
    }

    public void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int i = l, j = r;
        int tmp = nums[l];
        while (i < j) {
            while (i < j && nums[j] >= tmp) j--;
            if (i < j) {
                swap(nums, i, j);
            }
            while (i < j && nums[i] < tmp) i++;
            if (i < j) {
                swap(nums, i, j);
            }
        }
        nums[i] = tmp;
        quickSort(nums, l, i - 1);
        quickSort(nums, i + 1, r);
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    @Test
    public void test() {
//        int[] nums = {-2,0,1,1,2};
        int[] nums = {0, 0, 0};
        System.out.println(threeSum2(nums));
    }
}
