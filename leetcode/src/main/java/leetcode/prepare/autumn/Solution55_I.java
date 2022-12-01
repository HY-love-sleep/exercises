package leetcode.prepare.autumn;

import leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/27 16:36
 * @description：二叉树的深度
 */
public class Solution55_I {
    List<List<Integer>> list = new ArrayList<>();
    public int maxDepth(TreeNode root) {
        bfs(root);
        return list.size();
    }

    public void bfs(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int n = que.size();
            for (int i = 0; i < n; i++) {
                try {
                    TreeNode node = que.poll();
                    level.add(node.val);
                    if (node.left != null) {
                        que.offer(node.left);
                    }
                    if (node.right != null) {
                        que.offer(node.right);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            list.add(level);
        }
    }


    // 后序遍历返回左右子树最大深度 + 1
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLeft = maxDepth2(root.left);
        int maxRight = maxDepth2(root.right);
        return Math.max(maxLeft, maxRight) + 1;
    }
}
