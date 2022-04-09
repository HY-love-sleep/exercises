package leetcode.solution;

import leetcode.utils.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Solution35 {
    public int sumNumbers(TreeNode root) {
        int ans = 0;
        if (root == null) return 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            if (node.left == null && node.right == null) {
                ans += node.val;
            }
            if (node.left != null) {
                node.left.val = node.val * 10 + node.left.val;
                que.add(node.left);
            }
            if (node.right != null) {
                node.right.val = node.val * 10 + node.right.val;
                que.add(node.right);
            }
        }
        return ans;
    }

    @Test
    public void test() {
        int[] pre = {4, 9, 5, 1, 0};
        int[] in = {5, 9, 1, 4, 0};
        TreeNode root = new TreeNode().createTree(pre, in, 0, 4, 0, 4);
        System.out.println(sumNumbers(root));
    }
}
