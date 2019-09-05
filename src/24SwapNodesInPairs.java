// with dummy head
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, cur = head;

        while (cur != null && cur.next != null) {
            ListNode tmp = cur.next.next;
            pre.next = cur.next;
            cur.next.next = cur;
            cur.next = tmp;
            pre = cur;
            cur = cur.next;
        }

        return dummy.next;
    }
}

// w/o
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) return head;

        ListNode cur=head;
        ListNode newHead=head.next;
        ListNode pre=null;
        while (cur!=null&&cur.next!=null){
            ListNode temp=cur.next.next;
            if(pre!=null)   pre.next=cur.next;
            cur.next.next=cur;
            cur.next=temp;
            pre=cur;
            cur=temp;
        }
        return newHead;
    }
}
