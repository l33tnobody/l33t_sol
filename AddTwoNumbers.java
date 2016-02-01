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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode head = null;
        ListNode pre = null;
        int carry = 0;
        
        do{
            int val1 = l1==null? 0:l1.val;
            int val2 = l2==null? 0:l2.val;
            int sum = val1 + val2 + carry;
            ListNode newNode = new ListNode(sum%10);
            carry = sum>=10?1:0;
            if (head==null) head=newNode;
            if (pre!=null) pre.next=newNode;
            pre = newNode;
            l1 = l1==null? null:l1.next;
            l2 = l2==null? null:l2.next;
            
        } while (l1!=null||l2!=null||carry!=0);
        
        return head;
    }
}
