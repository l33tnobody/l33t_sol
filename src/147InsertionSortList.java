class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1), cur = head;

        while (cur != null) {
            ListNode p = dummy.next, prev = dummy;
            while (p != null && p.val < cur.val) {
                prev = p;
                p = p.next;
            }

            prev.next = cur;
            ListNode next = cur.next;
            cur.next = p;
            cur = next;
        }

        return dummy.next;
    }
}
