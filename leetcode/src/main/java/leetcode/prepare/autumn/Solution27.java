package leetcode.prepare.autumn;

import leetcode.utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/4 23:36
 * @description：镜像二叉树
 */
public class Solution27 {
    // 递归
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }

    // 辅助栈
    public TreeNode mirrorTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.poll();
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }
}
