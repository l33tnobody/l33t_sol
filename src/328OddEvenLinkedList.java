class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null; // optional

        ListNode odd = new ListNode(1);
        ListNode even = new ListNode(2);

        int i = 1;
        ListNode po = odd, pe = even, cur = head;

        while(cur!=null) {
            if(i%2 == 1) {
                po.next = cur;
                po = po.next;
            } else {
                pe.next = cur;
                pe = pe.next;
            }
            cur = cur.next;
            i++;
        }

        pe.next = null;
        po.next = null;
        po.next = even.next;

        return odd.next;
    }
}