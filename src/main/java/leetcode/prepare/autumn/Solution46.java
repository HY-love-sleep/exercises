package leetcode.prepare.autumn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution46 {
    public int translateNum(int num) {
        int[] nums = getNums(num);
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int k = nums[i - 2] * 10 + nums[i - 1];
            if (k >= 10 && k <= 25) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[n];
    }


    private int[] getNums(int num) {
        List<Integer> list = new ArrayList<>();
        if (num == 0) {
            list.add(0);
        }
        while (num > 0) {
            list.add(num % 10);
            num /= 10;
        }
        Collections.reverse(list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }


    @Test
    public void test() {
        System.out.println(translateNum(0));
    }
}
