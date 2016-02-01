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
public class Solution {
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null||head.next==null) return head;
        
        ListNode cur=head;
        ListNode newHead=head.next;
        ListNode pre=null;
        while (cur!=null&&cur.next!=null){
            ListNode temp=cur.next.next;
            if(pre!=null)   pre.next=cur.next;
            cur.next.next=cur;
            cur.next=temp;
            pre=cur;
            cur=temp;
        }
        return newHead;
    }
}
