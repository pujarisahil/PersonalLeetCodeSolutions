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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;

        ListNode current = head;
        int len = 0;
        while (current != null) {
            len++;
            current = current.next;
        }

        int lenUsed = 0;
        current = head;
        ListNode result = new ListNode(0);
        ListNode r = result;
        while (current != null) {
            ListNode prev = null, next = null;
            int i = 0;
            boolean wasHere = false;
            while (i < k && current != null && (len - lenUsed) >= k) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                i++;
                wasHere = true;
            }

            if (wasHere)
                current = prev;

            ListNode c = new ListNode(0);
            ListNode b = c;

            while (current != null) {
                b.next = new ListNode(current.val);
                b = b.next;
                current = current.next;
            }

            while (next != null) {
                b.next = new ListNode(next.val);
                b = b.next;
                next = next.next;
            }

            current = c.next;

            int j = 0;
            while (j < k && current != null) {
                r.next = new ListNode(current.val);
                r = r.next;
                current = current.next;
                j++;
                lenUsed++;
            }
        }

        return result.next;
    }
}