class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode cur = head, p = cur.next, prev = dummy;
        while (p != null) {
            while (p != null && p.val == cur.val)
                p = p.next;

            if (p != null && p != cur.next) {
                cur = p;
                prev.next = cur;
                p = p.next;
            } else if (p != null && p == cur.next) {
                prev = cur;
                cur = p;
                p = p.next;
            }
        }

        if (cur.next != null)
            prev.next = null; // last one at cur has dup, remove it

        return dummy.next;
    }
}