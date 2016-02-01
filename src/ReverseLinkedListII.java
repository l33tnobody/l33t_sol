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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode pre=null, prei=null, cur=head;
        
        for(int i=1; i<=n; i++){
            if(i==m)    pre=prei;
            
            ListNode nextnode=cur.next;
            if(i>m && i<=n){    //reverse
                cur.next=prei;
            }
            
            prei=cur;
            cur=nextnode;
            
        }
        
        if(pre!=null) {
            ListNode temp=pre.next; pre.next=prei; 
            if(temp!=null)  temp.next=cur;
            return head;
        }
        
        if(head!=null)  head.next=cur;
        return prei;  
        
    }
}
