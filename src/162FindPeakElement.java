// iterative binary search
public class Solution {
    public int findPeakElement(int[] nums) {
        int l=0;
        int r=nums.length - 1;

        while (l<r){
            int mid1=(l+r)/2;
            int mid2=mid1+1;
            if(nums[mid1]<nums[mid2])
                l=mid2;
            else
                r=mid1;
        }
        return r; // or return l
    }
}

// recursive binary search
public class Solution {
    public int findPeakElement(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    private int helper(int[] nums, int l, int r) {
        if (l==r)
            return r; // or return l
        int mid1 = (l+r)/2;
        int mid2 = mid1 + 1;
        if (nums[mid1] < nums[mid2])
            return helper(nums, mid2, r);
        else
            return helper(nums, l, mid1);
    }
}


// sequential search the first peak:
public class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n-1; i++) {
            if (nums[i] > nums[i+1]) return i;
        }
        return n-1;
    }
}

// straight forward but not good
public class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        for(int i=0; i<n; i++) {
            long left = (long)(i == 0 ? Long.MIN_VALUE : nums[i-1]);
            long right = (long)(i == n-1 ? Long.MIN_VALUE : nums[i+1]);
            long numi = (long)nums[i];
            // System.out.println("left " + left + " mid " + numi + " right " + right);
            if ( numi > left && numi > right ) {
                return i;
            } else if (numi >= right) {
                i++;
            }
        }

        return -1;
    }
}
