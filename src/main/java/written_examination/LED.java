package written_examination;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/24 19:34
 * @description：LED
 */
public class LED {
    public static void main(String[] args) {
        System.out.println(getTime(1));
    }

    public static List<String> getTime(int n) {
        StringBuilder sb = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            if (i < n) {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }
        String[] possibleTimes = permutation(sb.toString());
        List<String> res = new ArrayList<>();
        for (String possibleTime : possibleTimes) {
            int hour = Integer.parseInt(possibleTime.substring(0, 4), 2);
            int minutes = Integer.parseInt(possibleTime.substring(4, 10), 2);
            if (hour > 12 || minutes >= 60) {
                continue;
            }
            res.add("\"" + hour + ":" + (minutes < 10 ? "0" : "") + minutes + "\"");
        }
        return res;
    }

    // 全排列
    private static String[] permutation(String s) {
        char[] chs = s.toCharArray();
        Set<String> res = new HashSet<>();
        dfs(chs, 0, s.length() - 1, res);
        return res.toArray(new String[0]);
    }

    private static void swap(char[] chs, int a, int b) {
        char tmp = chs[a];
        chs[a] = chs[b];
        chs[b] = tmp;
    }

    private static void dfs(char[] chs, int i, int k, Set<String> res) {
        if (i == k) {
            res.add(String.valueOf(chs));
        }
        for (int j = i; j <= k; j++) {
            swap(chs, i, j);
            dfs(chs, i + 1, k, res);
            swap(chs, i, j);
        }
    }

}
