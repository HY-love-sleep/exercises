package leetcode.prepare.autumn;

import leetcode.utils.CreateList;
import leetcode.utils.ListNode;
import org.junit.Test;

import java.util.*;

public class Solution06 {
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode tmp = head;
        while (tmp != null) {
            list.add(tmp.val);
            tmp = tmp.next;
        }
        Collections.reverse(list);
        int[] res = new int[list.size()];
        int i = 0;
        for (int num : list) {
            res[i++] = num;
        }
        return res;
    }


    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        new CreateList();
        ListNode head = CreateList.createList(nums);
        System.out.println(Arrays.toString(reversePrint(head)));
    }
}
