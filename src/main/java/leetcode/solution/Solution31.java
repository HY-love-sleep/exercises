package leetcode.solution;

import org.junit.Test;

import java.util.*;

public class Solution31 {
    public List<Integer> treeSet(int[] nums) {
        Set<Integer> set = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int num : nums) {
            set.add(num);
        }
        return new ArrayList<>(set);
    }

    @Test
    public void test() {
        int[] nums = {2, 2, 1};
        System.out.println(treeSet(nums).toString());
    }
}
