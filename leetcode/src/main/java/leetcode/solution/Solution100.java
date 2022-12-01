package leetcode.solution;

import org.junit.Test;

public class Solution100 {
    public int getCnt(int num) {
        int ans = 0;  //累计喝了多少酒
        int wine = num; //手上有多少酒
        int bottle = 0;
        int cover = 0;

        while (wine > 0) {
            ans += wine;
            bottle += wine;
            cover += wine;
            wine = bottle / 2 + cover / 4;
            bottle = bottle % 2;
            cover = cover % 4;
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(getCnt(500));
    }
}
