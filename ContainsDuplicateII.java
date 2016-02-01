public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> num_index = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            if (num_index.containsKey(nums[i]) && i-num_index.get(nums[i])<=k)
                return true;
            num_index.put(nums[i], i); //update to latest index
        }
        return false;
    }
}
