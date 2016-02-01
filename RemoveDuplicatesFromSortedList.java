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
        if(head==null || head.next==null) return head;
        
        ListNode cur=head;
        ListNode p=head.next;
        
        for( ; p!=null; p=p.next){
            if(p.val!=cur.val) {
                cur.next=p;
                cur=p;
            }
        }
        cur.next=null;
        
        return head;
    }
}
