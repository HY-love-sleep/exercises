package leetcode.solution;

import leetcode.utils.TreeNode;

public class Solution51 {
    public int height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }


    // 自顶向下遍历 O(n^2)
    public boolean isBalance(TreeNode root) {
        if (root == null) return true;
        return (Math.abs(height(root.left) - height(root.right)) <= 1) && isBalance(root.left) && isBalance(root.right);
    }

    // 自底向上遍历 O(n)
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1)  return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }

}
