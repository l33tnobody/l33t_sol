// O(n^2)
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSame(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        
        if (s.val != t.val) return false;
        
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}

// O(n) Flatten to string and use KMP
// traverse and flatten with null is fine
// or using inorder and preorder or inorder and postorder
// preorder and postorder flattening cannot identify a unique tree
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return serialize(s).contains(serialize(t)); // Java uses a naive contains algorithm so to ensure linear time, replace with KMP algorithm
    }

    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        serialize(root, res);
        return res.toString();
    }

    private void serialize(TreeNode cur, StringBuilder res) {
        if (cur == null) {res.append(",#"); return;}
        res.append("," + cur.val);
        serialize(cur.left, res);
        serialize(cur.right, res);
    }
}