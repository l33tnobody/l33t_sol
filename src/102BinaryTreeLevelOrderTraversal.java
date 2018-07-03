class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)  return res;
        
        List<TreeNode> q = new ArrayList<>();
        q.add(root);
        
        while(q.size() > 0) {
            List<Integer> lvl = new ArrayList<>();
            List<TreeNode> newq = new ArrayList<>();
            
            for(TreeNode tn: q) {
                lvl.add(tn.val);
                if(tn.left != null)   newq.add(tn.left);
                if(tn.right != null)  newq.add(tn.right);
            }
            res.add(lvl);
            q = newq;
        }
        
        return res;
    }
}