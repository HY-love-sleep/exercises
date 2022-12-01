package leetcode.oneQuesOneDay;

import leetcode.utils.ListNode;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/12 17:23
 * @description：两两交换链表中的节点
 */
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dump= new ListNode(-1);
        dump.next = head;
        ListNode pre = dump;
        while (pre.next != null && pre.next.next != null) {
            ListNode temp = pre.next.next.next;
            ListNode A = pre.next;
            ListNode B = A.next;
            B.next = A;
            A.next = temp;
            pre.next = B;
            pre = A;
        }
        return dump.next;
    }

}
