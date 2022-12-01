package leetcode.solution;

import leetcode.utils.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution45 {
    public void reorderList(ListNode head) {
        ListNode mid = getMidNode(head);
        ListNode head2 = mid.next;
        mid.next = null;
        head2 = reverseListNode(head2);
        head = merge(head, head2);
    }

    // 反转链表
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

    // 找到链表中间节点[或左边中间节点]
    public ListNode getMidNode(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // 合并两个链表
    public ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        ListNode dump = new ListNode(-1);
        ListNode cur = dump, cur1 = head1, cur2 = head2;
        while (cur1 != null || cur2 != null) {
            cur.next = cur1;
            cur1 = cur1.next;
            cur = cur.next;
            if (cur2 != null) {
                cur.next = cur2;
                cur2 = cur2.next;
                cur = cur.next;
            }
        }
        return dump.next;
    }

}