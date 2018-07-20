// traverse and use a hashmap keyed on serialized tree string and mapping to an integer 
class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        preorder(root, new HashMap<>(), res);
        return res;
    }
    
    // return the serialized preorder for the current tree
    private String preorder(TreeNode cur, HashMap<String, Integer> map, List<TreeNode> res) {
        if(cur == null) return "#";
        
        String serial = cur.val + preorder(cur.left, map, res) + preorder(cur.right, map, res);
        if(map.getOrDefault(serial, 0) == 1) res.add(cur); // already exist one such subtree
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        return serial;
    }
}