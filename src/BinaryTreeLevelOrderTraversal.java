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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        if(root==null)  return res;
        
        ArrayList<TreeNode> buf=new ArrayList<TreeNode>();
        buf.add(root);
        
        while(buf.size()>0){
            ArrayList<Integer> lvl=new ArrayList<Integer>();
            ArrayList<TreeNode> newBuf=new ArrayList<TreeNode>();
            for(TreeNode tn: buf){
                lvl.add(tn.val);
                if(tn.left!=null)   newBuf.add(tn.left);
                if(tn.right!=null)  newBuf.add(tn.right);
            }
            res.add(lvl);
            buf=newBuf;
        }
        
        return res;
    }
}
