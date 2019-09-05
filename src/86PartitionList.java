class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode sm = new ListNode(-1), gt = new ListNode(0);
        ListNode sp = sm, gp = gt, cur = head;

        while (cur != null) {
            if (cur.val < x) {
                sp.next = cur;
                sp = sp.next;
            } else {
                gp.next = cur;
                gp = gp.next;
            }
            cur = cur.next;
        }

        sp.next = null;
        gp.next = null;
        if (sm.next == null)
            return gt.next;

        sp.next = gt.next;
        return sm.next;
    }
}

public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode cur=head;
        ListNode h1=null, h2=null, p1=null, p2=null;

        while(cur!=null){
            if(cur.val<x){
                if(h1==null)    {h1=cur; p1=cur;}
                else    {p1.next=cur; p1=cur;}
            }
            else{
                if(h2==null)    {h2=cur; p2=cur;}
                else    {p2.next=cur; p2=cur;}
            }
            cur=cur.next;
        }

        if(h2!=null)    p2.next=null;

        if(h1!=null)    {p1.next=h2; return h1;}
        else    return h2;

    }
}
