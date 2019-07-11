public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return null;

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

        head.next=cur;
        return prei;

    }
}
