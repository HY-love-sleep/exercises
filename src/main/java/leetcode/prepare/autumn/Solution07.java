package leetcode.prepare.autumn;

import leetcode.utils.TreeNode;

public class Solution07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return createTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode createTree(int[] pre, int[] in, int l1, int r1, int l2, int r2) {
        if (l1 > r1 || l2 > r2) {
            return null;
        }
        TreeNode root = new TreeNode(pre[l1]);
        int index = getIndex(in, pre[l1]);
        root.left = createTree(pre, in, l1 + 1, l1 + index - l2, l2, index - 1);
        root.right = createTree(pre, in, l1 + index - l2 + 1, r1, index + 1, r2);
        return root;
    }

    public int getIndex(int[] nums, int target) {
        for (int i = 0 ; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
