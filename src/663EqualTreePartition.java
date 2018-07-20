class Solution {
    public boolean checkEqualTree(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // from subtree sum to number of sums, for case of zero otherwise a hashset will suffice
        
        int sum = getsum(root, map);
        if(sum == 0) return map.get(0) > 1; // 0/2 is also 0
        return ( sum % 2 == 0 ) && (map.containsKey(sum / 2));
    }
    
    private int getsum(TreeNode root, Map<Integer, Integer> map) {
        if(root == null) return 0; // do not record null sum in map since the subtree has to contain a node
        int sum = getsum(root.left, map) + getsum(root.right, map) + root.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }
}