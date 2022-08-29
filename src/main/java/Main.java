import java.util.*;

/**
 * 3 3 2
 * 90 90 90
 * 80 100 90
 * 80 85 85
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int id = Integer.parseInt(str[2]);
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = sc.nextInt();
            }
        }

        System.out.println(getCount(nums, id));
    }

    private static int getCount(int[][] arr, int id) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum = sum + arr[i][j];
            }
            nums[i][0] = i;
            nums[i][1] = sum;
        }

        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int id1 = o1[0];
                int score1 = o1[1];
                int id2 = o2[0];
                int score2 = o2[1];
                if (score1 != score2) {
                    return score2 - score1;
                } else {
                    return id1 - id2;
                }
            }
        });

        for (int i = 0; i < n; i++) {
            if (nums[i][0] == id - 1) {
                return i + 1;
            }
        }
        return -1;
    }

}
