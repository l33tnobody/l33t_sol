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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(l1==null && l2==null) return null;
        if(l1==null) return l2;
        if(l2==null) return l1;
        
        ListNode pre=null, cur=null, head=null;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val)   {cur=l1; l1=l1.next;}
            else {cur=l2; l2=l2.next;}
            
            if(head==null)  {head=cur; pre=cur;}
            else {pre.next=cur; pre=cur;}
            
        }
        
        if(l1!=null)    pre.next=l1;
        else pre.next=l2;
        
        return head;
    }
}
