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
        
        if(head == null){
            return head;
        }
        boolean hasDuplicate = false;
    
        while(head.next!= null && head.next.val == head.val){
            head = head.next;
            hasDuplicate = true;
        }
        if(hasDuplicate){
            head=deleteDuplicates(head.next);
        }
        else{
            head.next=deleteDuplicates(head.next);
        }
        return head;
     
    }
}
