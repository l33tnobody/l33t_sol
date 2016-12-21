public class Solution {

    public List<TreeNode> generateTrees(int n) {
        if (n==0) return new ArrayList<TreeNode>(); // to get OJ pass, result should be an empty list
        return genTrees(1, n);
    }

    private List<TreeNode> genTrees(int start, int end) {
        List<TreeNode> list = new ArrayList<>();

        if(start>end) {
            list.add(null);
            return list;
        }

        if(start==end) {
            TreeNode root = new TreeNode(start);
            list.add(root);
            return list;
        }

        for(int i=start; i<=end; i++) {
            List<TreeNode> leftlist = genTrees(start, i-1);
            List<TreeNode> rightlist = genTrees(i+1, end);

            for(TreeNode l : leftlist) {
                for(TreeNode r : rightlist) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
        }

        return list;
    }

}
