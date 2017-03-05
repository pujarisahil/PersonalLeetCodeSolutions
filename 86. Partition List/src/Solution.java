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
    public ListNode partition(ListNode head, int x) {
        ListNode temp1 = new ListNode(0);
        ListNode temp2 = new ListNode(0);

        ListNode temp1Temp = temp1;
        ListNode temp2Temp = temp2;

        while (head != null) {
            int val = head.val;
            if (val < x) {
                temp1Temp.next = new ListNode(val);
                temp1Temp = temp1Temp.next;
            } else {
                temp2Temp.next = new ListNode(val);
                temp2Temp = temp2Temp.next;
            }
            head = head.next;
        }
        temp1Temp.next = temp2.next;

        return temp1.next;
    }
}