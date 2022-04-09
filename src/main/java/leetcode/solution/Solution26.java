package leetcode.solution;

import leetcode.utils.CreateList;
import leetcode.utils.ListNode;
import org.junit.Test;

import java.util.*;

public class Solution26 {
    List<Integer> list = new ArrayList<>();
    public int[] reversePrint(ListNode head) {
        recur(head);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void recur(ListNode node) {
        if (node == null) return;
        recur(node.next);
        list.add(node.val);
    }

    @Test
    public void test() {
        ListNode head = new CreateList().createList(new int[]{1,3,2});
        System.out.println(Arrays.toString(reversePrint(head)));
    }
}
