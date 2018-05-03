// binary search solution
public class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length-1;
        int l=1;
        int r=n;

        while(l<r){
            int mid = l+(r-l)/2;
            int count = 0;
            for(int a : nums){
                if (a<=mid) count++;
            }
            if (count<=mid) l=mid+1;
            else r=mid;
        }
        return l;
    }
}

// slow fast pointers solution
public class Solution {
    public int findDuplicate(int[] nums) {
       // the dup number will be the entrance of the loop
       int slow=nums[0];    // only 0 cannot be visited via integer 1~n, so visit 0 first.
       int fast=nums[nums[0]];

       while(fast!=slow){
           slow=nums[slow];
           fast=nums[nums[fast]];
       }

       fast=0; // reset to head

       while(fast!=slow){
           slow=nums[slow];
           fast=nums[fast];
       }
       return fast;
    }
}
