package leetcode.utils;

public class CreateList {
    public static ListNode createList(int[] nums) {
        int n = nums.length;
        if (n < 1) return null;
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        for (int num : nums) {
            cur.next = new ListNode(num);
            cur = cur.next;
        }
        return res.next;
    }

    public static void printList(ListNode node) {
        if (node == null) {
            System.out.println("list is empty");
        }
        while (node != null) {
            System.out.print(node.val + " , ");
            node = node.next;
        }
    }
}
