

import java.util.*;

public class Solution {
    public static int[] func(List<List<Integer>> times) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (List<Integer> list : times) {
            for (int time : list) {
                if (time > max) {
                    max = time;
                }
                if (time < min) {
                    min = time;
                }
            }
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = min; i <= max; i++) {
            List<Integer> ids = new ArrayList<>();
            int id = 0;
            for (List<Integer> time : times) {
                int left = time.get(0);
                int right = time.get(time.size() - 1);
                if (i >= left && i <= right) {
                    ids = map.getOrDefault(ids, new ArrayList<>());
                    ids.add(id);
                    map.put(i, ids);
                }
                id += 1;
            }
        }

        List<Float> res = new ArrayList<>();
        for (List<Integer> list : times) {
            float temp = 0.0f;
            for (int i = list.get(0); i < list.get(list.size() - 1); i++) {
                List<Integer> ids = map.get(i);
                if (ids.size() <= 1) {
                    temp += 1;
                } else {
                    temp += 1.0 / ids.size();
                }
            }
            res.add(temp);
        }
        int[] ans = new int[times.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = Math.round(res.get(i));
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(1234);
        A.add(1235);
        List<Integer> B = new ArrayList<>();
        B.add(1236);
        B.add(1238);
        List<List<Integer>> times = new ArrayList<>();
        times.add(A);
        times.add(B);
        System.out.println(Arrays.toString(func(times)));
    }
}