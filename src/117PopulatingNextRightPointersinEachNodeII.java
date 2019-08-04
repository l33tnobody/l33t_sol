/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
// best level by level BFS same as this question in Version I
 class Solution {
    public Node connect(Node root) {
        if (root == null)
            return null;

        List<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node n = q.remove(0);
                if (i != size - 1)
                    n.next = q.get(0); // else the last one's next in this level would be null
                if (n.left != null)
                    q.add(n.left);
                if (n.right != null)
                    q.add(n.right);
            }
        }

        return root;
    }
}

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
