/**
 * Created by sahilpujari on 2/25/17.
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        int i = 0;
        while (fast.next != null) {
            i++;
            fast = fast.next;
        }
        int j = i - k % i;
        while (j > 0) {
            slow = slow.next;
            j--;
        }

        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;

        return dummy.next;
    }
}