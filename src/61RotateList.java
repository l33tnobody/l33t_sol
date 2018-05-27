class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return head;

        ListNode p1 = head;
        int len = 0;
        while(p1 != null) {
            len++;
            p1 = p1.next;
        }
        k = k % len;
        if(k == 0)    return head; //special case, does not work with the below algorithm

        p1 = head;
        ListNode p2 = head;
        for(int i=0; i<k; i++){   //move p2 k times to the right
            p2 = p2.next;
        }

        while(p2.next != null){
            p2 = p2.next;
            p1 = p1.next;
        }   //p1 will potin to the new tail

        ListNode newhead = p1.next;
        p1.next = null;
        p2.next = head;
        return newhead;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
