// import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 2
 * 0 1
 * 0 10
 * 0 1
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] l = new int[n];
        int[] r = new int[n];
        int[] t = new int[n];

        for (int p = 0; p < n; p++) {
            l[p] = sc.nextInt();
        }
        for (int q = 0; q < n; q++) {
            r[q] = sc.nextInt();
        }
        for (int k = 0; k < n; k++) {
            t[k] = sc.nextInt();
        }

        int[] nums = new int[1000000];
        Arrays.fill(nums, Integer.MIN_VALUE);

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = l[i]; j <= r[i]; j++) {
                if (nums[j] == Integer.MIN_VALUE) {
                    nums[j] = f(j);
                }
                if (nums[j] == t[i]) {
                    cnt++;
                }
            }
            System.out.println(cnt);
            if (i != n - 1) {
                System.out.println(" ");
            }
        }
    }

    private static int f(int j) {
        int res = 0;
        while (j != 0) {
            res ^= j % 10;
            j /= 10;
        }
        return res;
    }


}