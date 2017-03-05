/**
 * Created by sahilpujari on 3/4/17.
 *
 * @author: Sahil Pujari (pujari@purdue.edu)
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return head;

        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode pre = temp;

        for (int i = 0; i < m - 1; i++) pre = pre.next;

        ListNode start = pre.next;
        ListNode dest = start.next;

        for (int i = 0; i < n - m; i++) {
            start.next = dest.next;
            dest.next = pre.next;
            pre.next = dest;
            dest = start.next;
        }

        return temp.next;
    }
}
