class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n <= 2) return n;

        int cur = 1;
        for(int i = 2; i < n; i++) {
            if(!(nums[i] == nums[cur]) || !(nums[i] == nums[cur-1])) nums[++cur] = nums[i];
        }

        return cur+1;
    }
}
