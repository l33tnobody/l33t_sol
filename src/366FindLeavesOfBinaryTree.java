// For this question we need to take bottom-up approach. The key is to find the height of each node. Here the definition of height is:
// The height of a node is the number of edges from the node to the deepest leaf. --CMU 15-121 Binary Trees
//
// I used a helper function to return the height of current node. According to the definition, the height of leaf is 0. h(node) = 1 + max(h(node.left), h(node.right)).
// The height of a node is also the its index in the result list (res). For example, leaves, whose heights are 0, are stored in res[0]. Once we find the height of a node,
// we can put it directly into the result.
// https://leetcode.com/problems/find-leaves-of-binary-tree/discuss/83778/10-lines-simple-Java-solution-using-recursion-with-explanation

class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        height(root, res);
        return res;
    }

    private int height(TreeNode root, List<List<Integer>> res) {
        if(root == null) return -1;

        int h = 1 + Math.max(height(root.left, res), height(root.right, res));
        if(res.size() < h + 1) res.add(new ArrayList<Integer>()); // or get root height first and init the res beforehand
        res.get(h).add(root.val);
        // root.left = null; root.right = null; // optional: remove the children
        return h;
    }
}

// or use hashmap to track outdegree and parents, using a queue to add 0 outdegree leaves
// and remove/update parents' outdegree iteratively
