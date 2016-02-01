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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null||head.next==null||k<=1) return head;
        
/*  k==1 nothing changed
        if(k==1) {
            ListNode res=reverse(head);
            return res;
        }
*/        
        ListNode newHead=head;
        ListNode cur=head;
        ListNode pre=null;
        ListNode tempHeadPre=null;
        ListNode tempHead=head;
        int count=0;
        
        while(cur!=null){
            count++;
            pre=cur;
            cur=cur.next;
            
            if(count==k){
                reverse(tempHead,pre);
                
                if(tempHeadPre==null)   newHead=pre;
                else tempHeadPre.next=pre;
                
                tempHead.next=cur;
                count=0;
                
                tempHeadPre=tempHead;
                tempHead=cur;
            }
        }
        
        return newHead;
    }
    
    private void reverse(ListNode head, ListNode tail){
        assert head!=null&&tail!=null;
        ListNode pre=null;
        ListNode cur=head;
        while(cur!=tail){
            ListNode temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        tail.next=pre;
    }
    
/*  k==1 nothing changed   
    private ListNode reverse(ListNode head){
        ListNode pre=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre; //new head
    }
*/
}
