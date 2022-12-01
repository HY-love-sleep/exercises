package written_examination;

import java.util.*;
public class Main{
    public static void main(String[] args) {

    }

    public static int getMinCount(int[] nums) {
        int n = nums.length;
        int a = 0, b = 0;

        for (int i = 0; i < n; i++) {
            if ((i % 2) == 1 && a < nums[i]) {
                a = nums[i];
            }

            if ((i % 2) == 0 && b < nums[i]) {
                b = nums[i];
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if ((i % 2) == 1) {
                res += a - nums[i];
            } else {
                res += b - nums[i];
            }
        }

        if (a != b) {
            return res;
        }
        return res + n / 2;

    }
}