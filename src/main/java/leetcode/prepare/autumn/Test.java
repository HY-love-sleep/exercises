package leetcode.prepare.autumn;

import leetcode.utils.TreeNode;
import sun.awt.image.ImageWatched;

import java.util.*;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/10 10:38
 * @description：测试
 */
public class Test {
    Deque<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return res;
    }

    private void dfs(TreeNode node, int target) {
       if (node == null) {
           return;
       }
       path.offerLast(node.val);
       target -= node.val;
       if (node.left == null && node.right == null && target == 0) {
           res.add(new ArrayList<>(path));
       }
       dfs(node.left, target);
       dfs(node.right, target);
       path.pollLast();
    }
}
