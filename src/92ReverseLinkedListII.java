class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = null, cur = head, next = null, pre0 = dummy;

        for (int i = 1; i <= n; i++) {
            if (i >= m) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            } else {
                pre0 = pre0.next;
                cur = cur.next;
            }
        }

        // cur will be the n+1 node, possibly null,
        // pre0 will be the one preceding the reversed list
        ListNode tail = pre0.next;
        pre0.next = pre;
        if (tail != null)
            tail.next = cur;

        return dummy.next;
    }
}
