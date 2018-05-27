// recursion and general plus number
class Solution {
    public ListNode plusOne(ListNode head) {
        int carry = recur(head, 1);
        if (carry != 0) {
            ListNode newhead = new ListNode(carry);
            newhead.next = head;
            head = newhead;
        }
        return head;
    }

    private int recur(ListNode cur, int num) {
        if(cur.next == null) {
            int sum = cur.val + num;
            cur.val = sum % 10;
            return sum / 10;
        }

        int carry = recur(cur.next, num);
        if(carry != 0) {
            int sum = cur.val + carry;
            cur.val = sum % 10;
            return sum / 10;
        }
        return 0;
    }
}

// or another solution based on the special +1, and find the last non 9 number
// and use a dummy head
public class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode i = dummy;
        ListNode j = dummy;

        while (j.next != null) {
            j = j.next;
            if (j.val != 9) {
                i = j;
            }
        }
        // i = index of last non-9 digit

        i.val++;
        i = i.next;
        while (i != null) {
            i.val = 0;
            i = i.next;
        }

        if (dummy.val == 0) return dummy.next;
        return dummy;
    }
}
