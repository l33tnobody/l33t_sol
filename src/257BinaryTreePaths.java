public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<String>();
        if (root != null )
            DFS(root, "", res);
        return res;
    }

    private void DFS(TreeNode root, String base, List<String> res) {
        String newBase = base + root.val;
        if(root.left == null && root.right == null){
            res.add(newBase);
            return;
        }
        if(root.left != null) DFS(root.left, newBase + "->", res);
        if(root.right != null) DFS(root.right, newBase + "->", res);
    }
}
