class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();       
        for(int n : nums) {
            if(s.contains(n)) return true;
            
            s.add(n);
        }
        return false;
    }
}

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0; i<nums.length - 1; i++) {
            if(nums[i] == nums[i+1]) return true;
        }
        return false;
    }
}