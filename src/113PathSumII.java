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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        LinkedList<Integer> cur = new LinkedList<>();
        dfs(root, sum, cur, res);
        return res;
    }

    private void dfs(TreeNode root, int sum, LinkedList<Integer> cur, List<List<Integer>> res){
        if (root==null)
            return;

        cur.add(root.val);
        int newSum=sum-root.val;

        if (newSum==0 && isLeaf(root)){
            res.add( (List) cur.clone() );
            cur.removeLast();
            return;
        }

        dfs(root.left, newSum, cur, res);
        dfs(root.right, newSum, cur, res);
        cur.removeLast();
        return;
    }

    private boolean isLeaf(TreeNode node) {
        if (node.left==null && node.right==null)
            return true;
        return false;
    }
}
