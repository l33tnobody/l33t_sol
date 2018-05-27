/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;

        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        ListNode pre = dummyhead;
        ListNode n1 = head;
        ListNode n2 = n1;

        while(n - 1 > 0 && n2.next != null) {
            n2 = n2.next;
            n--;
        }

        if(n - 1 > 0) return head;

        while(n2.next != null) {
            pre = pre.next;
            n1 = n1.next;
            n2 = n2.next;
        }

        pre.next = n1.next;
        n1.next = null;
        return dummyhead.next;
    }
}
