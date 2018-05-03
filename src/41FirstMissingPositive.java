class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length; // can just use a hashset here
        for(int i=0; i<n; i++) {
            if(nums[i] > 0 && nums[i] <= n) { // from 1 ~ n
                int j = nums[i] - 1; // intended position
                if(j != i && nums[i] != nums[j]) {
                    swap(nums, i, j);
                    i--;
                }
            }
        }

        for(int k=0; k<n; k++) {
            if(nums[k] != k+1) return k+1;
        }

        return n + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
