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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        ListNode slow = temp, fast = temp;

        int len = 0;
        while (fast != null) {
            fast = fast.next;
            len++;
        }

        if (len == n) return head.next;
        int i = 0;
        while (slow != null) {
            if (i == (len - n - 1)) {
                slow.next = slow.next.next;
            } else {
                slow = slow.next;
            }

            i++;
        }

        return head;
    }
}