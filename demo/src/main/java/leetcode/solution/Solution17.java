package leetcode.solution;

import org.junit.Test;

import java.util.*;

public class Solution17 {
    public String[][] topKstrings (String[] strings, int k) {
        // write code here
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : strings) {
            if (!map.containsKey(str)) {
                map.put(str, 1);
            } else {
                map.put(str, map.get(str) + 1);
            }
        }

        PriorityQueue<Map.Entry<String, Integer>> que = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue().equals(o2.getValue())) {
                    return o1.getKey().compareTo(o2.getKey());
                } else {
                    return o2.getValue().compareTo(o1.getValue());
                }
            }
        });
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (que.size() < k) {
                que.offer(entry);
            } else {
                assert que.peek() != null;
                if (entry.getValue() < que.peek().getValue()){
                    que.poll();
                    que.offer(entry);
                }
            }
        }

        String[][] res = new String[k][2];
        int i = 0;
        for (Map.Entry<String, Integer> entry : que) {
            res[i][0] = entry.getKey();
            res[i][1] = entry.getValue().toString();
            i++;
        }
        return res;
    }

    @Test
    public void test() {
        String[] strings = {"123","123","231","32"};
        System.out.println(Arrays.toString(topKstrings(strings, 2)));
    }
}
