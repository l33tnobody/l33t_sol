// use stacks and iterators to get next small and large elements: Time O(n), Space O(height of tree logn) 
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> stackl = new Stack<>(); // starts from min and return next smallest
        Stack<TreeNode> stackr = new Stack<>(); // starts from max and return next largest
        
        for(TreeNode cur = root; cur != null; cur = cur.left) stackl.push(cur);
        for(TreeNode cur = root; cur != null; cur = cur.right) stackr.push(cur);
        
        while(!stackl.isEmpty() && !stackr.isEmpty() && stackl.peek() != stackr.peek()) { // can not be the same node
            int sum = stackl.peek().val + stackr.peek().val;
            if(sum == k) return true;
            else if(sum < k) {
                for(TreeNode cur = stackl.pop().right; cur != null; cur = cur.left)
                    stackl.push(cur);
            } else {
                for(TreeNode cur = stackr.pop().left; cur != null; cur = cur.right)
                    stackr.push(cur);
            }
        }
        
        return false;
    }
}

// use set and traverse: O(n) time O(n) space
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> seen = new HashSet<>();
        return recur(root, seen, k);
    }
    
    private boolean recur(TreeNode root, Set<Integer> seen, int k) {
        if(root == null) return false;
        if(seen.contains(k - root.val)) return true;
        seen.add(root.val);
        return recur(root.left, seen, k) || recur(root.right, seen, k);
    }
}

// flatten and two pointers: O(n) time O(n) space
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        
        for(int i = 0, j = nums.size() - 1; i < j;){
            if(nums.get(i) + nums.get(j) == k) return true;
            if(nums.get(i) + nums.get(j) < k) i++;
            else j--;
        }
        return false;
    }
    
    public void inorder(TreeNode root, List<Integer> nums){
        if(root == null) return;
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }
}