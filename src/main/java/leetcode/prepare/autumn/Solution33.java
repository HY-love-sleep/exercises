package leetcode.prepare.autumn;

import org.junit.Test;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/9 23:26
 * @description：二叉搜索树的后序遍历序列
 */
public class Solution33 {
    public boolean verifyPostorder(int[] postorder) {
        return check(postorder, 0, postorder.length - 1);
    }

    private boolean check(int[] postorder, int i, int j) {
        if (i >= j) {
            return true;
        }
        int p = i;
        while (postorder[p] < postorder[j]) {
            p++;
        }
        int m = p;
        while (postorder[p] > postorder[j]) {
            p++;
        }
        return p == j && check(postorder, i, m - 1) && check(postorder, m, j - 1);
    }

    @Test
    public void test() {
        int[] post = {1,6,3,2,5};
        System.out.println(verifyPostorder(post));
    }
}
