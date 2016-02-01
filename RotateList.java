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
    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null||head.next==null) return head;
        
        ListNode p1=head;
        int len=0;
        while(p1!=null){
            len++;
            p1=p1.next;
        }
        
        int k=n%len;
        if(k==0)    return head;
        p1=head;
        ListNode p2=head;
        for(int i=0; i<k; i++){   //move p2 to the k+1th node
            p2=p2.next;
        }
        
        while(p2.next!=null){
            p2=p2.next;
            p1=p1.next;
        }   //p1 will potin to the new last node
        
        ListNode newhead=p1.next;
        p1.next=null;
        p2.next=head;
        return newhead;
    }
}
