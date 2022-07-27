package leetcode.prepare.autumn;

import leetcode.utils.TreeNode;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/27 16:54
 * @description：平衡二叉树
 */
public class Solution55_II {
    public boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return isBalanced;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);

        if (Math.abs(maxLeft - maxRight) > 1) {
            isBalanced = false;
            return 0;
        }

        return Math.max(maxLeft, maxRight) + 1;
    }
}
