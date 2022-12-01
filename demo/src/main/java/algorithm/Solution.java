package algorithm;

import leetcode.utils.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<Integer> list = new ArrayList<>();

    public TreeNode createTree(int[] pre, int[] in, int l1, int r1, int l2, int r2) {
        if (pre.length == 0) return null;
        if (l1 > r1 || l2 > r2) return null;
        TreeNode root = new TreeNode(pre[l1]);
        int m = getIN(pre[l1], in);
        root.left = createTree(pre, in, l1 + 1, l1 + m - l2, l2, m - 1);
        root.right = createTree(pre, in, l1 + m - l2 + 1, r1, m + 1, r2);
        return root;
    }

    public int getIN(int x, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        list.add(root.val);
    }


    @Test
    public void test() {
        int[] pre = {1, 2, 3, 4, 5, 6};
        int[] in = {3, 2, 1, 5, 4, 6};
        TreeNode root = createTree(pre, in, 0, 5, 0, 5);
        postOrder(root);
        System.out.println(list);
    }
}
