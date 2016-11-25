/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0); // dummy head will not be compared
        ListNode cur = head;
        ListNode newcur = dummy;
        while(cur!=null) {
            ListNode next = cur.next;
            while(newcur.next!=null && newcur.next.val<cur.val){
                newcur=newcur.next;
            }
            cur.next=newcur.next;
            newcur.next=cur;
            newcur=dummy;
            cur=next;
        }
        return dummy.next;
    }
}
