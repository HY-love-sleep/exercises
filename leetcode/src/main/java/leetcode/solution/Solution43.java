package leetcode.solution;

import leetcode.utils.CreateList;
import leetcode.utils.ListNode;
import org.junit.Test;

import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 *   public ListNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

public class Solution43 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode oddEvenList (ListNode head) {
        // write code here
        ListNode dump1 = new ListNode(-1);
        ListNode cur1 = dump1;
        ListNode dump2 = new ListNode(-1);
        ListNode cur2 = dump2;
        ListNode cur = head;
        boolean flag = true;
        while (cur != null) {
            if (flag) { //奇数
                cur1.next = cur;
                cur1 = cur1.next;
                cur = cur.next;
                flag = false;
            } else {
                cur2.next = cur;
                cur2 = cur2.next;
                cur = cur.next;
                flag = true;
            }
        }
        cur2.next = null;
        cur1.next = dump2.next;
        return dump1.next;
    }

    @Test
    public void test() {
        int[] nums = {2,1,3,5,6,4,7};
        ListNode head = new CreateList().createList(nums);
        head = oddEvenList(head);
        new CreateList().printList(head);
    }
}
