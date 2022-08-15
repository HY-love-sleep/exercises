package leetcode.oneQuesOneDay;

import leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/14 21:21
 * @description：验证二叉搜索树
 */
public class Solution98 {
    /** 解法一： 递归*/
    public boolean isValidBST(TreeNode root) {
        return recur(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean recur(TreeNode root, int minVal, int maxVal) {
        if (root == null) {
            return true;
        }
        if (root.val > minVal && root.val < maxVal) {
            return recur(root.left, minVal, root.val) && recur(root.right, root.val, maxVal);
        }
        return false;
    }

    /** 解法二： 中序遍历*/
    Stack<Long> stack = new Stack<>();
    boolean res = true;
    public boolean isValidBST2(TreeNode root) {
        stack.push(Long.MIN_VALUE);
        inorderSearch(root);
        return res;
    }

    private void inorderSearch(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderSearch(root.left);
        if (!stack.isEmpty() && root.val > stack.peek()) {
            stack.add((long) root.val);
            inorderSearch(root.right);
        } else {
            res = false;
        }
    }
}
