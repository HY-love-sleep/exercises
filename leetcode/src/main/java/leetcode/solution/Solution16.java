package leetcode.solution;

import leetcode.utils.CreateList;
import leetcode.utils.ListNode;
import org.junit.Test;

public class Solution16 {
    /**
     *
     * @param head ListNode类 the head node
     * @return ListNode类
     */
    public ListNode sortInList (ListNode head) {
        // write code here
        if (head == null || head.next == null) return head;
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
//        ListNode fast = head.next, slow = head;
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortInList(head);
        ListNode right = sortInList(tmp);
        ListNode dump = new ListNode(-1);
        ListNode tail = dump;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        tail.next = left == null ? right : left;
        return dump.next;
    }

    @Test
    public void test() {
        int[] nums = {1, 3, 2, 4, 5};
        CreateList cre = new CreateList();
        ListNode head = cre.createList(nums);
        cre.printList(sortInList(head));
    }
}
