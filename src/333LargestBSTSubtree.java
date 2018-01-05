class Solution {
    class Result {  //size of current tree, range of current tree lower, upper
        int size;
        int lower;
        int upper;

        Result(int size, int lower, int upper) {
            this.size = size;
            this.lower = lower;
            this.upper = upper;
        }
    }

    int max = 0;

    public int largestBSTSubtree(TreeNode root) {
        // if(root == null) return 0;
        traverse(root);
        return max;
    }

    private Result traverse(TreeNode root) {
        if(root == null) return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        Result l = traverse(root.left);
        Result r = traverse(root.right);
        if (l.size == -1 || r.size == -1 || root.val <= l.upper || root.val > r.lower) {
            // not a valid BST, here a valid BST means root > all left and root <= all right
            return new Result(-1, 0, 0);
        }
        int size = l.size + r.size + 1;
        max = Math.max(max, size);
        return new Result(size, Math.min(l.lower, root.val), Math.max(r.upper, root.val));
    }

}
