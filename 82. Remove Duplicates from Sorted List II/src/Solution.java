/**
 * Created by sahilpujari on 2/27/17.
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;

        while (curr != null) {
            while (curr.next != null && curr.val == curr.next.val)
                curr = curr.next;
            if (pre.next == curr)
                pre = pre.next;
            else
                pre.next = curr.next;
            curr = curr.next;
        }

        return dummy.next;
    }
}