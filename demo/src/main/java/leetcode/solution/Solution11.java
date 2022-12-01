package leetcode.solution;

import leetcode.utils.ListNode;

import java.util.PriorityQueue;

public class Solution11 {
    static class Status implements Comparable<Status> {

        int val;
        ListNode ptr;

        public Status(int val, ListNode ptr) {
            this.val = val;
            this.ptr = ptr;
        }

        @Override
        public int compareTo(Status o) {
            return this.val - o.val;
        }
    }

    PriorityQueue<Status> que = new PriorityQueue<>();

    public ListNode mergeKLists(ListNode[] lists) {
        for (ListNode node : lists) {
            if (node != null) {
                que.offer(new Status(node.val, node));
            }
        }

        ListNode dump = new ListNode(-1);
        ListNode tail = dump;
        while (!que.isEmpty()) {
            Status t = que.poll();
            tail.next = t.ptr;
            tail = tail.next;
            if (t.ptr.next != null) {
                que.offer(new Status(t.ptr.next.val, t.ptr.next));
            }
        }
        return dump.next;
    }
}
