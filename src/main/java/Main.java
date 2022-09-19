import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int ans = maxValue(nums, k, n);
        System.out.println(ans);
    }

    private static int maxValue(int[] nums, int k, int n) {
        if (nums.length == 0) {
            return 0;
        }
        k = Math.min(k, n / 2);
        int[] a = new int[k + 1];
        int[] b = new int[k + 1];

        a[0] = -nums[0];
        b[0] = 0;

        for (int i = 1; i <= k; i++) {
            a[i] = Integer.MIN_VALUE / 2;
            b[i] = Integer.MIN_VALUE / 2;
        }
        for (int i = 1; i < n; i++) {
            a[0] = Math.max(a[0], b[0] - nums[i]);
            for (int j = 1; j <= k; j++) {
                a[j] = Math.max(a[j], b[j] - nums[i]);
                b[j] = Math.max(b[j], a[j - 1] + nums[i]);
            }
        }
        return Arrays.stream(b).max().getAsInt();
    }
}