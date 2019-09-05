// merge sort
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
            return head;

        ListNode prev=null, slow=head, fast=head;
        while(fast!=null && fast.next!=null){ // can move two steps at a time
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null; // tie up the first half, have to break after prev, to break two nodes basic case
            // slow will be the beginning of the second half

        ListNode l1=sortList(head);
        ListNode l2=sortList(slow);

        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;

        while(l1!=null && l2!=null) {
            if(l1.val<l2.val){
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if(l1==null){
            p.next=l2;
        } else {
            p.next=l1;
        }

        return dummy.next;
    }
}
