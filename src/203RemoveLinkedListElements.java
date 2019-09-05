class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1), cur = head, prev = dummy;

        while(cur != null) {
            if(cur.val != val) {
                prev.next = cur;
                prev = prev.next;
            }
            cur = cur.next;
        }

        prev.next = null;
        return dummy.next;
    }
}