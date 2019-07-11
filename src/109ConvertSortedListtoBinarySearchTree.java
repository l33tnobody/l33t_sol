// slow and fast pointers
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return bst(head, null);
    }

    private TreeNode bst(ListNode head, ListNode tail){ // meaning not including tail but will include head
        if (head==tail) return null;

        ListNode slow = head;
        ListNode fast = head;
        while(fast!=tail && fast.next!=tail){
            slow=slow.next;
            fast=fast.next.next;
        }
        TreeNode n = new TreeNode(slow.val);
        n.left = bst(head, slow);
        n.right = bst(slow.next, tail);

        return n;
    }
}
