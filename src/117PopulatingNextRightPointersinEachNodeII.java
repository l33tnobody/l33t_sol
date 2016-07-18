/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

 // use a dummy head: simplify code and run faster
 public class Solution {
     public void connect(TreeLinkNode root) {
         TreeLinkNode cur = root;
         TreeLinkNode dummyHead = new TreeLinkNode(-1);
         TreeLinkNode prev = dummyHead;

         while(cur != null) {
             if (cur.left != null){
                 prev.next = cur.left;
                 prev = prev.next;
             }
             if (cur.right != null) {
                 prev.next  = cur.right;
                 prev = prev.next;
             }
             cur = cur.next;

             if (cur == null){
                 cur = dummyHead.next;
                 dummyHead.next = null;
                 prev = dummyHead;
             }
         }

     }
 }


public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode cur = root; // current node in the current level
        TreeLinkNode head = null; // head node of the next level
        TreeLinkNode prev = null; // prev node of the next level

        while (cur != null) {
            if (cur.left != null) {
                if (prev != null){
                    prev.next = cur.left;
                    prev = prev.next;
                } else {
                    head = cur.left;
                    prev = cur.left;
                }
            }

            if (cur.right != null) {
                if (prev != null){
                    prev.next = cur.right;
                    prev = prev.next;
                } else {
                    head = cur.right;
                    prev = cur.right;
                }
            }

            cur = cur.next;

            if (cur == null) {
                cur=head;
                head=null;
                prev=null;
            }
        }
    }
}
