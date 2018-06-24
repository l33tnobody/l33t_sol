// or pad the shorter linkedlist in the front
// to make it the same size as the long one
/**
 * singly-linked list.
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        };
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode prev = null;
        while(!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int v1 = s1.isEmpty() ? 0 : s1.pop();
            int v2 = s2.isEmpty() ? 0 : s2.pop();
            int val = v1 + v2 + carry;
            carry = val >= 10 ? 1 : 0;
            val %= 10;
            ListNode cur = new ListNode(val);
            cur.next = prev;
            prev = cur;
        }

        return prev;
    }

}
