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
