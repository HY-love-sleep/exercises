import leetcode.utils.CreateList;
import leetcode.utils.ListNode;
import org.junit.Test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String[] strs = str.split(" ");

    }

    // 反转[left, right]， 下标从1开始
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        int left = 1;
        while (cur != null && cur.next != null) {
            int right = left - 1;
            while (cur.next != null && cur.next.val != cur.val) {
                right += 1;
                cur = cur.next;
            }
            if (cur.next == null) {
                right += 1;
            }
            reverseBetween(head, left, right);
            left = right + 1;
            while (cur.next != null && cur.next.val == cur.val) {
                cur = cur.next;
                left += 1;
            }
            left += 1;
            cur = cur.next;
        }
        return head;
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 2, 3, 4, 5, 3, 3, 3, 4, 5};
//        int[] nums = {1, 1, 1, 2, 3, 4, 4, 5};
        ListNode head = CreateList.createList(nums);
        CreateList.printList(head);
        System.out.println(" ");
        reverse(head);
        CreateList.printList(head);
    }
}
