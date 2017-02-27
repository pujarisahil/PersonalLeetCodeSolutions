/**
 * Created by sahilpujari on 2/26/17.
 *
 * @author: Sahil Pujari (pujari@purdue.edu)
 */

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> n1Stack = new Stack<>();
        Stack<Integer> n2Stack = new Stack<>();

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                n1Stack.push(l1.val);
                l1 = l1.next;
            }

            if (l2 != null) {
                n2Stack.push(l2.val);
                l2 = l2.next;
            }
        }

        ListNode result = new ListNode(0);
        ListNode pre = result, next = result;
        int carry = 0;
        while (!n1Stack.isEmpty() || !n2Stack.isEmpty()) {
            int num = 0;
            if (!n1Stack.isEmpty()) {
                num += n1Stack.pop();
            }

            if (!n2Stack.isEmpty()) {
                num += n2Stack.pop();
            }
            num += carry;
            carry = 0;
            carry += num / 10;
            ListNode temp = new ListNode(num % 10);
            temp.next = result.next;
            result.next = temp;
        }

        if (carry != 0) {
            ListNode temp = new ListNode(carry);
            temp.next = result.next;
            result.next = temp;
        }

        return result.next;
    }
}
