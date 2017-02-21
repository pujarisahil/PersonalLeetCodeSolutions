/**
 * Created by sahilpujari on 10/13/16.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) return null;
        ListNode head = null;
        ListNode tail = null;

        int carry = 0;
        int i = 0;
        while(l1 != null || l2 != null) {
            int sum = 0;
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            sum += carry;
            carry = sum / 10;
            sum %= 10;

            if(i++ == 0) {
                head = new ListNode(sum);
                tail = head;
            } else {
                ListNode temp = new ListNode(sum);
                tail.next = temp;
                tail = temp;
            }
        }
        if(carry > 0) {
            tail.next = new ListNode(carry);
            tail = tail.next;
        }
        return head;
    }
}
