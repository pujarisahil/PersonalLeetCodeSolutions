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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;

        while (head != null && head.val == val) head = head.next;

        ListNode temp = head;
        ListNode next = null;


        while (temp != null && temp.next != null) {
            if (temp.next.val == val)
                temp.next = temp.next.next;
            else
                temp = temp.next;
        }

        return head;
    }
}