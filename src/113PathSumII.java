class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> cur = new LinkedList<>();
        dfs(root, sum, 0, cur, res);
        return res;
    }

    private void dfs(TreeNode root, int sum, int cursum, LinkedList<Integer> cur, List<List<Integer>> res) {
        if (root == null)
            return;

        cur.add(root.val);
        int newsum = cursum + root.val;
        if (root.left == null && root.right == null) {
            if (newsum == sum)
                res.add(new LinkedList<>(cur));
            cur.removeLast();
            return;
        }

        dfs(root.left, sum, newsum, cur, res);
        dfs(root.right, sum, newsum, cur, res);
        cur.removeLast();
    }
}