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
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        ListNode pre=head, cur=head;
        while(cur!=null){
            if(cur.next==null)  break;
            
            if(cur.next.val!=cur.val)   {pre=cur; cur=cur.next; continue;}
            
            ListNode temp=cur;
            while(cur.next.val==cur.val){
                cur=cur.next;
                if(cur.next==null)  break;
            }
            cur=cur.next;   //null or not equal value
            pre.next=cur;
            if(pre==temp)   {pre=cur; head=cur;}
        }
        return head;
    }
}
