public class Solution {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int tmp) {
        if (root == null) return 0;

        int newtmp = tmp*10 + root.val;
        if (isLeaf(root))
            return newtmp;

        return dfs(root.left, newtmp) + dfs(root.right, newtmp);
    }

    private boolean isLeaf(TreeNode root) {
        if (root.left == null && root.right == null)
            return true;
        return false;
    }
}

// shared var
public class Solution {

    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        sum = 0;
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode root, int tmp) {
        if (root == null) return;

        int newtmp = tmp*10 + root.val;
        if (isLeaf(root)) {
            sum+=newtmp;
            return;
        }
        dfs(root.left, newtmp);
        dfs(root.right, newtmp);
    }

    private boolean isLeaf(TreeNode root) {
        if (root.left == null && root.right == null)
            return true;
        return false;
    }
}
