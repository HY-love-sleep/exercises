package leetcode.prepare.autumn;

import java.util.*;

public class Solution45 {
    public String minNumber(int[] nums) {
//        String[] strs = new String[nums.length];
        List<String> strList = new ArrayList<>();
        for (int num : nums) {
            strList.add(String.valueOf(num));
        }
//        Collections.sort(strList, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return (o1 + o2).compareTo(o2 + o1);
//            }
//        });
        strList.sort((a, b) -> (a + b).compareTo(b + a));
        StringBuffer sb = new StringBuffer();
        for (String str : strList) {
            sb.append(str);
        }
        return sb.toString();
    }
}
