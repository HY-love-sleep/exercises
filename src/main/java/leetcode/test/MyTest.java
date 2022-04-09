package leetcode.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MyTest{
    List<String> res = new ArrayList<>();
    public List<String> allRange(char[] chars) {
        recur(chars, 0, chars.length);
        return res;
    }

    public void recur(char[] chars, int k, int m) {
        if (k == m) {
            res.add(new String(chars));
        }
        for (int i = k; i < m; i++) {
            swap(chars, i, k);
            recur(chars, k + 1, m);
            swap(chars, i, k);
        }
    }

    public void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    @Test
    public void test() {
        char[] chars = {'A', 'B', 'C'};
        System.out.println(allRange(chars));
    }

    @Test
    public void test1() {
        System.out.println(1<<3);
    }
}
