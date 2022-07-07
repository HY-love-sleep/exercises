package leetcode.prepare.autumn;

import leetcode.utils.ListNode;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/4 23:10
 * @description：反转链表
 */
public class Solution24 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = head, cur = head,next;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            if (pre == head) {
                pre.next = null;
            }
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
