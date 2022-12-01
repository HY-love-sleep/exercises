package leetcode.solution;

import leetcode.utils.TreeNode;
import org.junit.Test;

import java.util.*;

public class Solution4 {
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        if (root == null) return -1;
        // 层次遍历记录每个节点的父节点
        HashMap<Integer, Integer> parent = new HashMap<>();
        Queue<TreeNode> que= new LinkedList<>();
        que.add(root);
        parent.put(root.val, Integer.MAX_VALUE);
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            if (node.left != null) {
                que.add(node.left);
                parent.put(node.left.val, node.val);
            }
            if (node.right != null) {
                que.add(node.right);
                parent.put(node.right.val, node.val);
            }
        }

        //记录从o1到root的路径
        HashSet<Integer> path1 = new HashSet<>();
        while(parent.containsKey(o1)) {
            path1.add(o1);
            o1 = parent.get(o1);
        }

        //遍历o2到root的路径
        while(parent.containsKey(o2)) {
            if (path1.contains(o2)) {
                return o2;
            }
            o2 = parent.get(o2);
        }
        return o2;
    }

    @Test
    public void test() {
        int[] pre = {3,5,6,2,7,4,1,0,8}, in = {6,5,7,2,4,3,0,1,8};
        TreeNode root = new TreeNode().createTree(pre, in, 0, pre.length - 1, 0, in.length - 1);
        System.out.println(lowestCommonAncestor(root, 6, 7));

    }

}
