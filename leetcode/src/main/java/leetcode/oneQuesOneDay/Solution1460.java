package leetcode.oneQuesOneDay;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/24 13:54
 * @description：通过翻转子数组使两个数组相等
 */
public class Solution1460 {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> targetMap = new HashMap<>(target.length);
        Map<Integer, Integer> arrMap = new HashMap<>(arr.length);
        for (int num : target) {
            targetMap.put(num, targetMap.getOrDefault(num, 0) + 1);
        }
        for (int num : arr) {
            arrMap.put(num, arrMap.getOrDefault(num, 0) + 1);
        }
        if (targetMap.size() != arrMap.size()) {
            return false;
        }
        for (Map.Entry<Integer, Integer> entry : targetMap.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if (!arrMap.containsKey(key) || arrMap.get(key) != val) {
                return false;
            }
        }
        return true;
    }
}
