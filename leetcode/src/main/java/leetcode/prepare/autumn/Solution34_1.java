package leetcode.prepare.autumn;

import leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/9 23:35
 * @description：二叉树中和为某一值的路径
 */
public class Solution34_1 {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return res;
    }

    private void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        target -= root.val;
        if (root.left == null && root.right == null && target == 0) {
            res.add(new ArrayList<>(path));
        }
        dfs(root.left, target);
        dfs(root.right, target);
        path.pollLast();
    }


}
