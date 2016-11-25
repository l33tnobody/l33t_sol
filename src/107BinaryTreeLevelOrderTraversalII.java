/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null) return res;

        List<TreeNode> level = new ArrayList<>();
        level.add(root);

        while(!level.isEmpty()){
            List<Integer> lres = new ArrayList<>();
            List<TreeNode> newlevel = new ArrayList<>();
            for(TreeNode n : level){
                lres.add(n.val);
                if(n.left!=null) newlevel.add(n.left);
                if(n.right!=null) newlevel.add(n.right);
            }
            res.add(lres);
            level=newlevel;
        }

        Collections.reverse(res);
        return res;
    }
}
