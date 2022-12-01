package leetcode.prepare.autumn;

import leetcode.utils.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution37 {
    public String serialize(TreeNode root) {
        return rSerialize(root, "");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strArray = data.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(strArray));
        return rDeserialize(list);
    }

    private String rSerialize(TreeNode root, String str) {
        if (root == null) {
            str += "None,";
        } else {
            str += root.val + ",";
            str = rSerialize(root.left, str);
            str = rSerialize(root.right, str);
        }
        return str;
    }

    private TreeNode rDeserialize(List<String> list) {
        if ("None".equals(list.get(0))) {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        root.left = rDeserialize(list);
        root.right = rDeserialize(list);
        return root;
    }

    @Test
    public void test() {
        int[] pre = {1,2,3,4,5};
        int[] in = {3,2,4,1,5};
        TreeNode root = TreeNode.createTree(pre, in, 0, 4, 0, 4);
        System.out.println(serialize(root));
    }
}
