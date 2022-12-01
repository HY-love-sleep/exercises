package leetcode.prepare.autumn;

import org.junit.Test;

import java.util.*;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/20 21:56
 * @description：第一个只出现一次的字符
 */
public class Solution50 {
    public char firstUniqChar(String s) {
        char ans = ' ';
        Map<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int[] nums;
            if (!map.containsKey(s.charAt(i))) {
                nums = new int[]{i, 1};
            } else {
                nums = new int[]{map.get(s.charAt(i))[0], map.get(s.charAt(i))[1] + 1};
            }
            map.put(s.charAt(i), nums);
        }
        List<Map.Entry<Character, int[]>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<Character, int[]>>() {
            @Override
            public int compare(Map.Entry<Character, int[]> o1, Map.Entry<Character, int[]> o2) {
                if (o1.getValue()[1] == o2.getValue()[1]) {
                    return o1.getValue()[0] - o2.getValue()[0];
                }
                return o1.getValue()[1] - o2.getValue()[1];
            }
        });
        for (Map.Entry<Character, int[]> entry : list) {
            if (entry.getValue()[1] == 1) {
                ans = entry.getKey();
                break;
            }
        }
        return ans;
    }

    @Test
    public void test() {
        String s = "leetcode";
        System.out.println(firstUniqChar(s));
    }
}
