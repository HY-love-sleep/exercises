package leetcode.solution;

import leetcode.utils.CreateList;
import leetcode.utils.ListNode;
import org.junit.Test;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseListNode(l1);
        l2 = reverseListNode(l2);
        int flag = 0;
        ListNode dump = new ListNode(-1);
        ListNode cur = dump;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int tmp = val1 + val2 + flag;
            flag = tmp / 10;
            tmp %= 10;
            cur.next = new ListNode(tmp);
            cur = cur.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (flag > 0) {
            cur.next = new ListNode(flag);
        }
        ListNode ans = reverseListNode(dump.next);
        return ans;
    }

    public ListNode reverseListNode(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    @Test
    public void test() {
        int[] nums1 = {2,4,3};
        int[] nums2 = {5,6,4};
        ListNode head1 = new CreateList().createList(nums1);
        ListNode head2 = new CreateList().createList(nums2);
        ListNode ans = addTwoNumbers(head1, head2);
        new CreateList().printList(ans);
//        System.out.println();
    }
}