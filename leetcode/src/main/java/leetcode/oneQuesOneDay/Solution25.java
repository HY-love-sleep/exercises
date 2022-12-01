package leetcode.oneQuesOneDay;

import leetcode.utils.ListNode;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/25 17:16
 * @description：k个一组反转链表
 */
public class Solution25 {
    public ListNode reverseKGroup (ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        ListNode newHead = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    /**
     * 反转链表[a,b)间的节点
     * @param a
     * @param b
     * @return
     */
    private ListNode reverse(ListNode a, ListNode b) {
        ListNode pre = null, cur = a, next = a;
        while (cur != b) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
