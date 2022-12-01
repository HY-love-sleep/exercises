package leetcode.prepare.autumn;

import leetcode.utils.TreeNode;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/7 23:00
 * @description：从上到下打印二叉树
 */
public class Solution32_1 {
    /**
     * 二叉树的层次遍历
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        List<Integer> list = new ArrayList<>();
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            list.add(node.val);
            if (node.left != null) {
                que.offer(node.left);
            }
            if (node.right != null) {
                que.offer(node.right);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}
