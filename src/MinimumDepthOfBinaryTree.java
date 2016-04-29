/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null) return 0;

        ArrayList<TreeNode> buf=new ArrayList<TreeNode>();
        buf.add(root);
        int d=0;

        while(buf.size()>0){
            d++;
            ArrayList<TreeNode> newBuf=new ArrayList<TreeNode>();
            boolean reachLeaf=false;
            for(TreeNode tn: buf){
                if(tn.left!=null)   newBuf.add(tn.left);
                if(tn.right!=null)  newBuf.add(tn.right);
                if(tn.left==null && tn.right==null)   {reachLeaf=true; break;}
            }
            if(reachLeaf)   break;
            buf=newBuf;
        }

        return d;
    }
}

// BFS: reuse same queue
public class Solution {
    public int minDepth(TreeNode root) {
        if (root==null) return 0;

        int min_d = 1;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        int counter = 1;
        while(counter>0){
            TreeNode n = q.removeFirst();
            counter--;
            if (n.left==null && n.right==null) break;

            if (n.left!=null) q.add(n.left);
            if (n.right!=null) q.add(n.right);
            if (counter==0){
                counter=q.size();
                min_d++;
            }
        }
        return min_d;
    }
}

// recursive
public class Solution {
    public int minDepth(TreeNode root) {
        if (root==null) return 0;
        if (root.left==null) return minDepth(root.right) + 1;
        if (root.right==null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}

// BFS: new queue for each level
public class Solution {
    public int minDepth(TreeNode root) {
        if (root==null) return 0;

        int min_d = 1;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            LinkedList<TreeNode> newq = new LinkedList<>();
            boolean reachLeaf = false;
            for(TreeNode n : q){
                if (n.left==null && n.right==null){
                    reachLeaf = true;
                    break;
                }
                if (n.left!=null) newq.add(n.left);
                if (n.right!=null) newq.add(n.right);
            }

            if(reachLeaf) break;

            q = newq;
            min_d++;
        }

        return min_d;
    }
}
