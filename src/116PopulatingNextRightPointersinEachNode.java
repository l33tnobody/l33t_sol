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




// recursion: O(logn) or O(height of the tree) complexity
// has duplication where left.next = right.
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null) return ;

        link(root.left,root.right);
    }

    public void link(TreeLinkNode left, TreeLinkNode right){

        if(left==null && right==null) return ;

        left.next = right;
        link(left.left,left.right);
        link(left.right,right.left);
        link(right.left,right.right);
    }
}

//using level by level traversal, surprisingly the runtime is worse than recursion
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        ArrayList<TreeLinkNode> q = new ArrayList<TreeLinkNode>();
        q.add(root);

        while(q.size()!=0){
            int counter = q.size();
            while(counter!=0){
                TreeLinkNode n = q.remove(0);
                counter--;
                if (counter!=0) n.next = q.get(0);
                // else the last node.next is already init to null.
                if (n.left!=null) q.add(n.left);
                if (n.right!=null) q.add(n.right);
            }
        }
    }
}
