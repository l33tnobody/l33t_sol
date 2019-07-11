/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// recursive dfs:
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int maxleft = maxDepth(root.left);
        int maxright = maxDepth(root.right);
        
        int res = Math.max(maxleft, maxright) + 1;
        return res;
    }
}

// bfs with a single queue:
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int d = 0;
        
        while(q.size() > 0) {
            d++;
            for(int sz = q.size(); sz > 0; sz--) {
                TreeNode tn = q.poll();
                if(tn.left != null)   q.add(tn.left);
                if(tn.right != null)  q.add(tn.right);
            }
        }
        
        return d;
    }
}



// bfs:
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        
        List<TreeNode> q = new LinkedList<>();
        q.add(root);
        int d = 0;
        
        while(q.size() > 0) {
            d++;
            List<TreeNode> newq = new LinkedList<>();
            
            for(TreeNode tn : q){
                if(tn.left != null)   newq.add(tn.left);
                if(tn.right != null)  newq.add(tn.right);
            }
            
            q = newq;
        }
        
        return d;
    }
}
