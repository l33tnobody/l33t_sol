/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head==null) return null;

        return bst(head, null);
    }

    private TreeNode bst(ListNode head, ListNode tail){
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
