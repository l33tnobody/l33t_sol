class Solution {
    public boolean search(int[] nums, int target) {
        int n=nums.length;
        int l=0,r=n-1;

        while(l<=r){
            int m=(l+r)/2;
            if(nums[m]==target) return true;

            if(nums[l]<nums[m]){
                if(target>=nums[l]&&target<nums[m]){
                    r=m-1;
                    continue;
                }else{
                    l=m+1;
                    continue;
                }
            }else if(nums[l]>nums[m]){  //right half is sorted
                if(target>nums[m]&&target<=nums[r]){
                    l=m+1;
                    continue;
                }else{
                    r=m-1;
                    continue;
                }
            }else   //nums[l]==nums[m] get rid of nums[l], O(n) worst case
                l++;
                // while(l < n && nums[l] == nums[m]) l++;
                // while(r >= 0 && nums[r] == nums[m]) r--;
        }
        return false;
    }
}
