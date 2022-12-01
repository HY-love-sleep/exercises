package leetcode.solution;

import org.junit.Test;

public class Solution58 {
    public int findJudge(int n, int[][] trust) {
        int len = trust.length;
        int[] in = new int[n + 1];
        int[] out = new int[n + 1];
        for (int[] edg : trust) {
            int a = edg[0];
            int b = edg[1];
            in[b]++;
            out[a]++;
        }
        for (int i = 1; i <= n; i++) {
            if (in[i] == n - 1 && out[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        int[][] nums = {{1, 3}, {2, 3}, {3, 1}};
        System.out.println(findJudge(3, nums));
    }
}
