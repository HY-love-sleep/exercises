package leetcode.prepare.autumn;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ：hongyan
 * @date ：Created in 2022/6/25 16:02
 * @description：字符串全排列
 */
public class Solution38 {
    public String[] permutation(String s) {
        char[] chs = s.toCharArray();
        Set<String> res = new HashSet<>();
        dfs(chs, 0, s.length() - 1, res);
        return res.toArray(new String[0]);
    }

    private void swap(char[] chs, int a, int b) {
        char tmp = chs[a];
        chs[a] = chs[b];
        chs[b] = tmp;
    }

    private void dfs(char[] chs, int i, int k, Set<String> res) {
        if (i == k) {
            res.add(String.valueOf(chs));
        }
        for (int j = i; j <= k; j++) {
            swap(chs, i, j);
            dfs(chs, i + 1, k, res);
            swap(chs, i, j);
        }
    }

    @Test
    public void test() {
        String s = "abc";
        System.out.println(Arrays.toString(permutation(s)));
    }
}
