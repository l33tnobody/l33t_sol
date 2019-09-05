class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode cur = head;
        ListNode p = head.next;

        while (p != null) {
            if (p.val != cur.val) {
                cur.next = p;
                cur = p;
            }
            p = p.next;
        }
        cur.next = null;

        return head;
    }
}