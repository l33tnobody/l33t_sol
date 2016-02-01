// https://leetcode.com/course/chapters/leetcode-101/range-sum-query-immutable/
public class NumArray {
    // Caching with O(n) space
    private int[] sums;

    public NumArray(int[] nums) {
        sums = new int[nums.length + 1];
        for (int i=0; i<nums.length; i++){
            sums[i+1] = sums[i] + nums[i];
        }
    }
    // constant retrieval
    public int sumRange(int i, int j) {
        return sums[j+1] - sums[i];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
