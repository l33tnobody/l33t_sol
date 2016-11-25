public class Solution {
    public void reorderList(ListNode head) {
        if (head==null || head.next==null) return;

        // find the middle
        ListNode slow=head;
        ListNode fast=head;
        ListNode preslow=head; // track the last element in the first half to tie it up

        while(fast!=null && fast.next!=null){
            preslow=slow;
            slow=slow.next;
            fast=fast.next.next;
        }

        preslow.next=null; // tie up the first half

        ListNode l2=reverse(slow);
        ListNode l1=head; // shorter by one if odd number, or evenly long if even number

        merge(l1, l2);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev=null;
        ListNode curr=head;

        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    private void merge(ListNode l1, ListNode l2) { // l1 shorter or even
        ListNode prev=null;
        ListNode p1=l1;
        ListNode p2=l2;

        while(p1!=null){
            ListNode n1 = p1.next;
            ListNode n2 = p2.next;
            p1.next=p2;
            if (prev!=null)
                prev.next=p1;
            prev=p2;
            p1=n1;
            p2=n2;
        }
    }
}
