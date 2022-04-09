package leetcode.utils;

import lombok.Data;

@Data
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }

    public TreeNode() {
        left = null;
        right = null;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public static TreeNode createTree(int[] pre, int[] in, int l1, int r1, int l2, int r2) {
        if (l1 > r1 || l2 > r2) return null;
        TreeNode root = new TreeNode(pre[l1]);
        int pivot = getIndex(in, pre[l1]);
        root.left = createTree(pre, in, l1 + 1, l1 + pivot - l2, l2, pivot - 1);
        root.right = createTree(pre, in, l1 + pivot - l2 + 1, r1, pivot + 1, r2);
        return root;
    }

    public static int getIndex(int[] nums, int x) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                return i;
            }
        }
        return -1;
    }
}


