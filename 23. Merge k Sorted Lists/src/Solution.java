/**
 * Created by sahilpujari on 10/25/16.
 */

import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length < 1)
            return null;

        PriorityQueue<Integer> myQ = new PriorityQueue<>();
        for(ListNode n : lists) {
            while(n != null) {
                myQ.add(n.val);
                n = n.next;
            }
        }

        if(myQ.size() == 1) {
            ListNode head = new ListNode(myQ.remove());
            return head;
        }

        if(myQ.size() >= 2) {
            ListNode head = new ListNode(myQ.remove());
            ListNode next = new ListNode(myQ.remove());
            head.next = next;
            while(!myQ.isEmpty()) {
                ListNode temp = new ListNode(myQ.remove());
                next.next = temp;
                next = next.next;
            }
            return head;
        }
        return null;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
