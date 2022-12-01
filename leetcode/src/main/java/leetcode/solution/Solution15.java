package leetcode.solution;

import leetcode.utils.TreeNode;
import org.junit.Test;

import java.util.*;


public class Solution15 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 求二叉树的右视图
     * @param xianxu int整型一维数组 先序遍历
     * @param zhongxu int整型一维数组 中序遍历
     * @return int整型一维数组
     */
    public int[] solve (int[] xianxu, int[] zhongxu) {
        // write code here
        TreeNode root = buildTree(xianxu, zhongxu, 0, xianxu.length - 1, 0, zhongxu.length - 1);
        ArrayList<ArrayList<Integer>> level = levelSearch(root);
        int[] ans = new int[level.size()];
        int i = 0;
        for (ArrayList<Integer> l : level) {
            ans[i++] = l.get(l.size() - 1);
        }
        return ans;
    }

    public TreeNode buildTree(int[] pre, int[] in, int l1, int r1, int l2, int r2) {
        if (l1 > r1 || l2 > r2) return null;
        TreeNode root = new TreeNode(pre[l1]);
        int index = getIndex(in, pre[l1]);
        root.left = buildTree(pre, in, l1 + 1, l1 + index - l2, l2, index - 1);
        root.right = buildTree(pre, in, l1 + index - l2 + 1, r1, index + 1, r2);
        return root;
    }

    public static int getIndex(int[] nums, int x) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<ArrayList<Integer>> levelSearch(TreeNode root) {
        if (root == null) return null;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            int levelSize = que.size();
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = que.poll();
                assert node != null;
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
        return res;
    }

    @Test
    public void test() {
        int[] pre = {1,2,4,5,3};
        int[] in = {4,2,5,1,3};
        System.out.println(Arrays.toString(solve(pre, in)));
    }
}