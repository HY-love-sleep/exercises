package leetcode.prepare.autumn;

import leetcode.utils.ListNode;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/27 11:08
 * @description：两个链表的第一个公共节点
 */
public class Solution52 {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        while (cur1 != cur2) {
            cur1 = cur1 == null ? headB : cur1.next;
            cur2 = cur2 == null ? headA : cur2.next;
        }
        return cur1;
    }
}
