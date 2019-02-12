// recursion:
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % k != 0) return false;

        boolean[] visited = new boolean[nums.length];
        // int target = sum/k;
        // for (int n : nums)
        //     if(n > target) return false; // optimization: if one number is greater than average then, there is no possible partition
        return canPartition(nums, k, visited, 0, 0, sum/k);
    }

    private boolean canPartition(int[] nums, int k, boolean[] visited, int cur, int cursum, int target) {
        if (k == 1) return true;
        if (cursum == target) return canPartition(nums, k - 1, visited, 0, 0, target);

        for(int i=cur; i<nums.length; i++) {
            // if(i == 1 && visited[0] == false) break; // can use this line to quit faster when number at index 0 has no matching group
            if(visited[i] == false && cursum + nums[i] <= target){
                visited[i] = true;
                if(canPartition(nums, k, visited, i + 1, cursum + nums[i], target)) return true;
                visited[i] = false;
            }
        }
        return false;
    }
}
