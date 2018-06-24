class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyhead = new ListNode(-1);
        ListNode cur = dummyhead;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0) {
            int v1 = (l1 == null) ? 0 : l1.val;
            int v2 = (l2 == null) ? 0 : l2.val;
            int sum = v1 + v2 + carry;
            ListNode newnode = new ListNode(sum%10);
            carry = (sum > 9) ? 1 : 0;
            cur.next = newnode;
            cur = cur.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        return dummyhead.next;
    }
}
