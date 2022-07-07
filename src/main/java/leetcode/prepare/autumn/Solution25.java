package leetcode.prepare.autumn;

import leetcode.utils.ListNode;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/4 23:14
 * @description：合并两个排序链表
 */
public class Solution25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dump = new ListNode(-1);
        ListNode cur = dump;
        ListNode cur1 = l1, cur2 = l2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        cur.next = cur1 == null ? cur2 : cur1;
        return dump.next;
    }
}
