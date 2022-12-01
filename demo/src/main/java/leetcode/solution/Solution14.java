package leetcode.solution;

import org.junit.Test;

import java.util.ArrayList;

public class Solution14 {
    public ArrayList<Integer> seqSum(int N, int L) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int n = L; n < 101; n++) {
            int k = 2 * N + n - n * n;
            if (k % (2 * n) == 0) {
                int m = k / (2 * n);
                res.add(m);
                for (int i = 0; i < n - 1; i++) {
                    res.add(++m);
                }
                break;
            }
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(seqSum(5050, 26));
    }
}
