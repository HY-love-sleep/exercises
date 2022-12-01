package leetcode.prepare.autumn;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/31 14:30
 * @description：圆圈中最后剩下的数字
 */
public class Solution62 {
    static class Node{
        int val;
        Node next;

        public Node() {}
        public Node(int x) {
            this.val = x;
        }
    }
    public int lastRemaining(int n, int m) {
        Node head = new Node(0);
        Node cur = head;
        for (int i = 1; i < n; i++) {
            cur.next = new Node(i);
            cur = cur.next;
        }
        cur.next = head;
        while (cur.next != null) {
            if (cur.next == cur) {
                break;
            }
            for (int i = 0; i < m - 1; i++) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return cur.val;
    }

    public int lastRemaining2(int n, int m) {
        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + m) % i;
        }
        return dp[n];
    }

    public int lastRemaining3(int n, int m) {
        int a = 0, b = 0;
        for (int i = 2; i <= n; i++) {
            b = (a + m) % i;
            a = b;
        }
        return b;
    }
}
