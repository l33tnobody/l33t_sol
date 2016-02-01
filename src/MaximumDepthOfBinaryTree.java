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
    public int maxDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null) return 0;
        
        ArrayList<TreeNode> buf=new ArrayList<TreeNode>();
        buf.add(root);
        int d=0;
        
        while(buf.size()>0){
            d++;
            ArrayList<TreeNode> newBuf=new ArrayList<TreeNode>();
            for(TreeNode tn: buf){
                if(tn.left!=null)   newBuf.add(tn.left);
                if(tn.right!=null)  newBuf.add(tn.right);
            }
            buf=newBuf;
        }
        
        return d;
    }
}
