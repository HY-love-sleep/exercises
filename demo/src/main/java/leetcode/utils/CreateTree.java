package leetcode.utils;

import java.lang.reflect.InvocationHandler;

public class CreateTree {
    public static class TreeValue {
        public static int index = 0;
        //先序遍历存储，0表示空节点\
        public static final int[] TREE_VALUE = new int[]{3,9,0,0,20,15,0,0,7,0,0};
//        public static final int[] TREE_VALUE = new int[]{0};
    }
    public static TreeNode createTree(TreeNode node, int i) {
        if (0 == TreeValue.TREE_VALUE[i]) {
            return null;
        } else {
            node.setVal(TreeValue.TREE_VALUE[i]);
        }

        TreeNode leftChild = new TreeNode();
        node.left = createTree(leftChild, ++TreeValue.index);
        TreeNode rightChild = new TreeNode();
        node.right = createTree(rightChild, ++TreeValue.index);

        return node;
    }
}
