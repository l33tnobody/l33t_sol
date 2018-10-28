public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> st=new Stack<>();
        TreeNode cur=root;
        List<Integer> res = new ArrayList<>();
        
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
