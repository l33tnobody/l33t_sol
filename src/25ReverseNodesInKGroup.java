class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1)
            return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy, cur = dummy, next = null;
        int c = 0;

        while (cur != null) {
            cur = cur.next;
            c++;

            if (cur != null && c == k) {
                next = cur.next;
                cur.next = null;
                ListNode rev = reverse(prev.next);
                ListNode tail = prev.next;
                prev.next = rev;
                tail.next = next;
                cur = tail;
                c = 0;
                prev = tail;
            }
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, cur = head, next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}