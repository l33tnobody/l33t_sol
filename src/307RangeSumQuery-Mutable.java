// segment tree
// both logn time for update and query, n time for build
public class NumArray {

    class SegmentTreeNode {
        int start, end, val;
        SegmentTreeNode left, right;

        SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.val = 0;
        }
    }

    private SegmentTreeNode myroot;

    public NumArray(int[] nums) {
        myroot = buildTree(nums, 0, nums.length-1);
    }

    private SegmentTreeNode buildTree(int[] nums, int s, int e) {
        if (s>e) return null;

        SegmentTreeNode res = new SegmentTreeNode(s, e);
        if (s==e) {
            res.val=nums[s];
        } else { // s<e
            int m = s + (e - s)/2;
            res.left = buildTree(nums, s, m);
            res.right = buildTree(nums, m+1, e);
            res.val = res.left.val + res.right.val;
        }

        return res;
    }

    void update(int i, int val) {
        updateTree(myroot, i, val);
    }

    private void updateTree(SegmentTreeNode root, int i, int val) {
        if (root.start == root.end) {
            root.val = val;
            return;
        }

        int m = root.start + (root.end - root.start)/2;
        if (i<=m) {
            updateTree(root.left, i, val);
        } else {
            updateTree(root.right, i, val);
        }
        root.val = root.left.val + root.right.val;
    }

    public int sumRange(int i, int j) {
        return sumRangeTree(myroot, i, j);
    }

    private int sumRangeTree(SegmentTreeNode root, int i, int j) {
        if (root.end < i || root.start > j) return 0;

        if (root.start >= i && root.end <= j) return root.val;

        return sumRangeTree(root.left, i, j) + sumRangeTree(root.right, i, j);

    }
}



// another Binary Indexed Tree solution:
// https://discuss.leetcode.com/topic/31599/java-using-binary-indexed-tree-with-clear-explanation


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
