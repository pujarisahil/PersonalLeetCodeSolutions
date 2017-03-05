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
    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return null;
        if (head != null && head.next == null)
            return head;

        ListNode result = new ListNode(0);
        ListNode temp = result;
        ListNode h = head;

        while (h != null && h.next != null) {

            ListNode a = new ListNode(h.val);
            ListNode b = new ListNode(h.next.val);

            b.next = a;

            temp.next = b;
            temp = temp.next.next;

            h = h.next.next;
        }

        if (h != null) temp.next = h;

        return result.next;
    }
}