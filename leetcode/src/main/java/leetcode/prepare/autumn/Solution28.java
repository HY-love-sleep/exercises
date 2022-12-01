package leetcode.prepare.autumn;

import com.sun.jmx.remote.internal.ArrayQueue;
import leetcode.utils.CreateTree;
import leetcode.utils.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/6 21:59
 * @description：对称的二叉树
 */
public class Solution28 {
    // 1、递归
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    // 2、迭代
    public boolean isSymmetric2(TreeNode root) {
        return check2(root, root);
    }

    private boolean check2(TreeNode p, TreeNode q) {
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(p);
        que.offer(q);
        while (!que.isEmpty()) {
            TreeNode u = que.poll();
            TreeNode v = que.poll();
            if (u == null && v == null) {
                continue;
            }
            if (u == null || v == null || (u.val != v.val)) {
                return false;
            }

            que.offer(u.left);
            que.offer(v.right);
            que.offer(u.right);
            que.offer(v.left);
        }
        return true;
    }
}
