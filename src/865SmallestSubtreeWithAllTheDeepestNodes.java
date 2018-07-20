// top down depth approach: cache depth to avoid nlogn: O(n)
class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root == null) return null;
        Map<TreeNode, Integer> map = new HashMap<>(); // cache depth for each node 
        depth(root, map);
        return dfs(root, map);    
    }
    
    public int depth(TreeNode root, Map<TreeNode, Integer> map) {
        if(root == null ) return 0;
        if(map.containsKey(root)) return map.get(root); // when use as cache
        int max = Math.max(depth(root.left, map), depth(root.right, map)) + 1;
        map.put(root,max);   
        return max;
    }
    
    public TreeNode dfs(TreeNode root, Map<TreeNode, Integer> map) {
        int left = depth(root.left, map);
        int right = depth(root.right, map);
        if(left == right) return root; // from top if left depth == right depth return root
        if(left > right) return dfs(root.left, map);
        return dfs(root.right, map);
    }
}

// one pass O(n) solution: return possible result node with depth, same depth return root, otherwise return result node from the deeper child
class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return deep(root).getValue();
    }

    public Pair<Integer, TreeNode> deep(TreeNode root) {
        if (root == null) return new Pair(0, null);
        Pair<Integer, TreeNode> l = deep(root.left), r = deep(root.right);

        int d1 = l.getKey(), d2 = r.getKey();
        return new Pair(Math.max(d1, d2) + 1, d1 == d2 ? root : d1 > d2 ? l.getValue() : r.getValue());
    }
}
