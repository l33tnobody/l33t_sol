// note: slow and fast two pointers swap won't preserve order for greater or equal ones but only for smaller ones

// separate into two lists
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
        sp.next = gt.next;

        return sm.next;
    }
}

