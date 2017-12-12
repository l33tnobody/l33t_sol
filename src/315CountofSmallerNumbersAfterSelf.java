// mergesort based solution better!
// sort on indexes to keep track of the reversecount
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        int[] indexes = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
    	    indexes[i] = i;
            res.add(0);
        }
        mergesort(nums, indexes, res, 0, nums.length - 1);
        return res;
    }

    private void mergesort(int[] nums, int[] indexes, List<Integer> res, int start, int end){
        if (end <= start) return;

        int mid = start + ((end - start) >> 1);
        mergesort(nums, indexes, res, start, mid);
        mergesort(nums, indexes, res, mid+1, end);

        int l = start, r = mid + 1, p = 0;
        int reversecount = 0;
        int[] tmp = new int[end - start + 1];

        for(; l <= mid; l++, p++) {
            while(r <= end && nums[indexes[r]] < nums[indexes[l]]) {
                tmp[p++] = indexes[r++];
                reversecount++;
            }
            tmp[p] = indexes[l];
            res.set(indexes[l], res.get(indexes[l]) + reversecount);
        }

        for(int k = 0; k < p; k++) indexes[start+k] = tmp[k];
    }
}


// has no duplicate node with same value:
class Solution {
    class TreeNode {
        TreeNode left, right;
        int val;
        int count = 0; // number of smaller ones
        int dup = 1;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new LinkedList<>();
        if(nums.length == 0) return res;

        res.add(0);
        TreeNode root = new TreeNode(nums[nums.length - 1]);
        for(int i = nums.length - 2; i >= 0; i--) {
            int count = insertNode(root, nums[i]);
            res.add(0, count);
        }

        return res;
    }

    private int insertNode(TreeNode root, int val) {
        int count = 0; // number of elements smaller than the current number
        while(true) {
            if (val < root.val) {
                root.count++;
                if (root.left == null) {
                    root.left = new TreeNode(val);
                    break;
                } else {
                    root = root.left;
                }
            } else if (val > root.val) {
                count += root.count + root.dup;
                if (root.right == null) {
                    root.right = new TreeNode(val);
                    break;
                } else {
                    root = root.right;
                }
            } else { // val == root.val
                root.dup++;
                count += root.count;
                break;
            }
        }
        return count;
    }
}

// has duplicate nodes for the same value:
class Solution {
    class TreeNode {
        TreeNode left, right;
        int val;
        int count = 1;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new LinkedList<>();
        if(nums.length == 0) return res;

        res.add(0);
        TreeNode root = new TreeNode(nums[nums.length - 1]);
        for(int i = nums.length - 2; i >= 0; i--) {
            int count = insertNode(root, nums[i]);
            res.add(0, count);
        }

        return res;
    }

    private int insertNode(TreeNode root, int val) {
        int count = 0; // number of elements smaller than the current number
        while(true) {
            if (val <= root.val) {
                root.count++;
                if (root.left == null) {
                    root.left = new TreeNode(val);
                    break;
                } else {
                    root = root.left;
                }
            } else { // val > root.val
                count += root.count;
                if (root.right == null) {
                    root.right = new TreeNode(val);
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        return count;
    }
}
