package leetcode.prepare.autumn;

import leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/27 16:19
 * @description：二叉搜索树的第k大节点
 */
public class Solution54 {
    int k, res;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        if (k == 0) {
            return;
        }
        if (--k == 0) {
            res = root.val;
        }
        dfs(root.left);
    }
}
