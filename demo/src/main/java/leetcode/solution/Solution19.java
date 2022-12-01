package leetcode.solution;

import org.junit.Test;

public class Solution19 {
    int triangle_nums(int n) {
        if (n < 3) return 0;
        int ans = 0;
        if (n % 2 == 0) { //偶数个顶点
            int k = n / 2;
            int t = 0;
            for (int i = 1; i < k; i++) {
                if ((2 * i) >= k) {
                    t++;
                }
            }
            ans = n * t;
        } else { //奇数个顶点
            int k = (n - 1) / 2;
            int t = 0;
            for (int i = 1; i < k; i++) {
                if ((2 * i) > k) {
                    t++;
                }
            }
            ans = n * t;
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(triangle_nums(15));
    }
}