class Solution {
    private int max = 0;
    
    public int longestUnivaluePath(TreeNode root) {
        maxdown(root);
        return max;

        // if does not want to use a global var:
        // int[] max = new int[1]; // only use this array trying to pass it by reference
        // maxdown(root, max);
        // return max[0];
    }
    
    private int maxdown(TreeNode cur) {
        if(cur == null) return 0;
        int l = maxdown(cur.left);
        int r = maxdown(cur.right);
        int res = 1, maxl = 1, maxr = 1;
        if(cur.left != null && cur.val == cur.left.val) {
            res += l;
            maxl += l;
        }
        if(cur.right != null && cur.val == cur.right.val) {
            res += r;
            maxr += r;
        }
        max = Math.max(max, res - 1);
        return Math.max(maxl, maxr);
    }
}