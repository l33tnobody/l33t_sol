/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

// best solution
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root==null) return;
        TreeLinkNode cur = root;
        TreeLinkNode nextLeftMost = null;

        // assume the current level is already linked (i.e root node)
        // and link the next level
        while(cur.left != null){
            nextLeftMost = cur.left; // save the start of the next level
            while(cur != null){
                cur.left.next = cur.right;
                cur.right.next = (cur.next==null ? null : cur.next.left);
                cur = cur.next;
            }
            cur = nextLeftMost; // move down to the next level
        }
    }
}

// using level by level traversal, surprisingly the runtime is worse than recursion
// use linkedlist is faster
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





// recursion: O(logn) or O(height of the tree) complexity
// has duplication where left.next = right.
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;

        link(root.left, root.right);
    }

    public void link(TreeLinkNode left, TreeLinkNode right) {

        if (left == null && right == null)
            return;

        left.next = right;
        link(left.left, left.right);
        link(left.right, right.left);
        link(right.left, right.right);
    }
}