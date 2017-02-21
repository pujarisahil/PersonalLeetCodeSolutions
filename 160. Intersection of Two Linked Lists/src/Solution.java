/**
 * Created by sahilpujari on 11/2/16.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
      next = null;
    }
}
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        int len1 = 0, len2 = 0;
        while(p1 != null) {
            len1++;
            p1 = p1.next;
        }

        while(p2 != null) {
            len2++;
            p2 = p2.next;
        }
        p1 = headA;
        p2 = headB;

        if(len1 < len2) {
            int diff = len2 - len1;
            int i = 0;
            while(i < diff) {
                p2 = p2.next;
                i++;
            }
        } else if(len1 > len2) {
            int diff = len1 - len2;
            int i = 0;
            while(i < diff) {
                p1 = p1.next;
                i++;
            }
        }

        while(p1 != null && p2 != null) {
            if(p1.val == p2.val) {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }
}