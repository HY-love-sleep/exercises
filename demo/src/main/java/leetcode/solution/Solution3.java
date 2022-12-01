package leetcode.solution;

import leetcode.utils.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;

public class Solution3 {
    public int sumNumbers (TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = 0;

        ArrayDeque<TreeNode> node = new ArrayDeque<>();
        ArrayDeque<Integer> value = new ArrayDeque<>();
        node.addFirst(root);
        value.addFirst(root.val);

        while (!node.isEmpty()) {
            TreeNode nod = node.pollFirst();
            int val = value.pollFirst();
            if (nod.left == null && nod.right == null) {
                ans += val;
            } else {
                if (nod.left != null) {
                    node.addFirst(nod.left);
                    value.addFirst(val * 10 + nod.left.val);
                }
                if (nod.right != null) {
                    node.addFirst(nod.right);
                    value.addFirst(val * 10 + nod.right.val);
                }
            }
        }
        return ans;
    }

    @Test
    public void test() {
        int[] pre = {3,5,6,2,7,4,1,0,8}, in = {6,5,7,2,4,3,0,1,8};
        TreeNode root = new TreeNode().createTree(pre, in, 0, pre.length - 1, 0, in.length - 1);
        System.out.println(sumNumbers(root));
    }
}
