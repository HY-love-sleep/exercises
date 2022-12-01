package leetcode.prepare.autumn;

import leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/7 23:12
 * @description：从上到下打印二叉树2
 */
public class Solution32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                tmp.add(node.val);
                if (node.left != null) {
                    que.add(node.left);
                }
                if (node.right != null) {
                    que.add(node.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }
}
