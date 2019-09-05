// find the middle node and reverse the second half
// two pointer
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = null;
        if (fast == null) {
            secondHalf = reverseList(slow);
        } else {
            secondHalf = reverseList(slow.next);
        }

        // secondHalf shorter by 1 or equal to the first half length
        while (secondHalf != null) {
            if (head.val != secondHalf.val)
                return false;
            head = head.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}








// recursive, it needs duplicated comparison when p1 and p2 pass each other
public class Solution {
    private ListNode p1;

    public boolean isPalindrome(ListNode head) {
        p1 = head;
        return check(head);
    }

    private boolean check(ListNode p2){
        if (p2 == null)
            return true;
        boolean res = check(p2.next) && (p2.val == p1.val);
        p1 = p1.next;
        return res;
    }
}
