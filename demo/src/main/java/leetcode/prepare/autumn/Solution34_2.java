package leetcode.prepare.autumn;

import leetcode.utils.TreeNode;

import java.util.*;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/9 23:49
 * @description：二叉树中和为某一值的路径
 */
public class Solution34_2 {
    List<List<Integer>> res= new ArrayList<>();
    Map<TreeNode, TreeNode> map = new HashMap<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queNode = new LinkedList<>();
        Queue<Integer> queSum = new LinkedList<>();
        queNode.offer(root);
        queSum.offer(0);
        while (!queNode.isEmpty()) {
            TreeNode node = queNode.poll();
            int rec = queSum.poll() + node.val;
            if (node.left == null && node.right == null) {
                if (rec == target) {
                    getPath(node);
                }
            } else {
                if (node.left != null) {
                    map.put(node.left, node);
                    queNode.add(node.left);
                    queSum.add(rec);
                }
                if (node.right != null) {
                    map.put(node.right, node);
                    queNode.add(node.right);
                    queSum.add(rec);
                }
            }
        }
        return res;
    }

    private void getPath(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.val);
            node = map.get(node);
        }
        Collections.reverse(list);
        res.add(new ArrayList<>(list));
    }
}
