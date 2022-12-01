package leetcode.oneQuesOneDay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/4 22:57
 * @description：最小绝对差
 */
public class Solution1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int best = Integer.MAX_VALUE;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] < best) {
                best = arr[i + 1] - arr[i];
                res.clear();
                List<Integer> tmp = new ArrayList<>();
                tmp.add(arr[i]);
                tmp.add(arr[i + 1]);
                res.add(tmp);
            } else if (arr[i + 1] - arr[i] == best) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(arr[i]);
                tmp.add(arr[i + 1]);
                res.add(tmp);
            }
        }
        return res;
    }
}
