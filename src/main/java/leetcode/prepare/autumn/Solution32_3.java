package leetcode.prepare.autumn;

import leetcode.utils.TreeNode;

import java.util.*;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/7 23:24
 * @description：从上到下打印二叉树3
 */
public class Solution32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                level.add(node.val);
                if (node.left != null) {
                    que.add(node.left);
                }
                if (node.right != null) {
                    que.add(node.right);
                }
            }
            res.add(level);
        }
        for (int i = 0; i < res.size(); i++) {
            if (i % 2 == 1) {
                Collections.reverse(res.get(i));
            }
        }
        return res;
    }
}
