// O(n) time, O(1) space (does not count recursion space and result space) using the BST attribute of sorting order
class Solution {
    Integer prev = null;
    int count = 1;
    int max = 0;
    
    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>(); // record all max, not sure how many max are there
        inorder(root, list); 
        
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) res[i] = list.get(i);
        return res;
    }
    
    private void inorder(TreeNode cur, List<Integer> list) {
        if(cur == null) return;
        
        inorder(cur.left, list);
        
        if(prev != null) {
            if(cur.val == prev) count++;
            else count = 1;
        }
        
        if(count > max) {
            max = count;
            list.clear();
            list.add(cur.val);
        } else if(count == max){
            list.add(cur.val);
        }
        
        prev = cur.val;
        inorder(cur.right, list);
    }
}


// trivial O(n) time and O(n) space which does not take into consideration about BST's sorting order
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;
    
    public int[] findMode(TreeNode root) {
        inorder(root);
        
        List<Integer> ls = new ArrayList<>();
        for(int k : map.keySet()) {
            if(map.get(k) == max) ls.add(k);
        }
        
        int[] res = new int[ls.size()];
        for(int i = 0; i < res.length; i++) res[i] = ls.get(i);
        return res;
    }
    
    private void inorder(TreeNode cur) {
        if(cur == null) return;
        inorder(cur.left);
        map.put(cur.val, map.getOrDefault(cur.val, 0) + 1);
        max = Math.max(max, map.get(cur.val));
        inorder(cur.right);
    }
}