package leetcode.solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution24 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        recur(n, 0, 0, path, res);
        return res;
    }

    public void recur(int n, int left, int right, StringBuilder path, List<String> res) {
        if (path.length() == 2 * n) {
            res.add(path.toString());
            return;
        }
        if (left < n) {
            path.append('(');
            recur(n, left + 1, right, path, res);
            path.deleteCharAt(path.length() - 1);
        }
        if (right < left) {
            path.append(')');
            recur(n, left, right + 1, path, res);
            path.deleteCharAt(path.length() - 1);
        }
    }

    @Test
    public void test() {
        System.out.println(generateParenthesis(3));
    }
}
