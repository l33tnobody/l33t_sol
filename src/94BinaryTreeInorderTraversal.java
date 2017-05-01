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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<TreeNode> st=new Stack<TreeNode>();
        TreeNode cur=root;
        ArrayList<Integer> res=new ArrayList<Integer>();
        
        while(cur!=null || !st.isEmpty()){
            if(cur!=null){
                st.push(cur);
                cur=cur.left;
            }else{
                cur=st.pop();
                res.add(cur.val);
                cur=cur.right;
            }
        }
        
        return res;
    }
}
