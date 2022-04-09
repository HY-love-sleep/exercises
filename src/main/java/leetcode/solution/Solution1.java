package leetcode.solution;

import leetcode.utils.CreateList;
import leetcode.utils.ListNode;
import org.junit.Test;

import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */

public class Solution1 {
    /**
     *
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        ListNode ans = new ListNode(-1);
        ListNode cur = ans;
        ListNode a = reverse(head1);
        ListNode b = reverse(head2);
        int carry = 0;
        while (a != null || b != null) {
            int valA = a == null ? 0 : a.val;
            int valB = b == null ? 0 : b.val;
            cur.next = new ListNode((valA + valB + carry) % 10);
            carry = (valA + valB + carry) / 10;
            cur = cur.next;
            if (a != null) {
                a = a.next;
            }
            if (b != null) {
                b = b.next;
            }
        }
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return reverse(ans.next);
    }

    public ListNode reverse(ListNode head) {
        if (head == null) return null;
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
        return pre;
    }

    @Test
    public void test() {
        int[] num1 = {9,3,7}, num2 = {6, 3};
        ListNode head1 = new CreateList().createList(num1);
        ListNode head2 = new CreateList().createList(num2);
        ListNode ans = addInList(head1, head2);
        new CreateList().printList(ans);
    }
}
