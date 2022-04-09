package leetcode.solution;

import org.junit.Test;

public class Solution34 {
    public int roundCnt(int a, int b, int c, int d) {
        int ans = 0;
        int flag = 0; // 这回合中残血碉堡的生命值
        while (a > 0 || d > 0) {
            // 小七进攻
//            int missVal = a; //损失的生命值
            if (flag != 0) {  // 真残血了
                a -= flag;
                d -= 1;
            }
            if (a > 0) {
                d -= a / b;
                flag = b - (a % b);
            }

            // 城堡进攻
            a -= c * d;

            //回合次数加一
            ans += 1;
        }
        if (d == 0) return ans;
        return -1;
    }

    @Test
    public void test() {
        System.out.println(roundCnt(10, 6, 8, 2));
    }
}
