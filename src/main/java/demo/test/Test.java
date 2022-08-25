package demo.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;




/**
 * @author ：hongyan
 * @date ：Created in 2022/8/24 10:27
 * @description：测试
 */
public class Test {
    private static void permutation(char[] str, int k, int m, Set<String> res) {
        if (k == m) {
            res.add(Arrays.toString(str));
        }
        for (int i = k; i <= m; i++) {
            swap(str, i, k);
            permutation(str, k + 1, m, res);
            swap(str, i, k);
        }
    }

    private static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    public static void main(String[] args) {
        String s = "ABC";
        Set<String> res = new HashSet<>();
        permutation(s.toCharArray(), 0, s.length() - 1, res);
        String[] ans = res.toArray(new String[0]);
        for (String str : ans) {
            System.out.println(str);
        }
    }
}
