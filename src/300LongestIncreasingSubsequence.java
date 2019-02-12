// dp on ending at index
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len==0) return 0;

        int[] dp=new int[len];
        Arrays.fill(dp, 1);
        int res=1;

        for(int i=1; i<len; i++) { // where the current increasing sequence ends
            for(int j=0; j<i; j++){
                if(nums[i]>nums[j])
                    // dp[i] records the longest sequence ends AT i
                    dp[i]=Math.max(dp[i], dp[j]+1);
            }
            res=Math.max(res, dp[i]);
        }

        return res;
    }
}

// dp on starting at index
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len==0) return 0;

        int[] dp=new int[len];
        Arrays.fill(dp, 1);
        int res=1;

        for(int i=len-2; i>=0; i--){ // where the current increasing sequence starts
            for(int j=i+1; j<len; j++){
                if(nums[i]<nums[j])
                    // dp[i] records the longest sequence starts AT i
                    dp[i]=Math.max(dp[i], dp[j]+1);
            }
            res=Math.max(res, dp[i]);
        }

        return res;
    }
}

// nlogn: greedy tracking the longest increasing sequence
// http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len==0) return 0;

        int[] tailTable = new int[len];
        tailTable[0]=nums[0];

        int n=1;
        for(int i=1; i<len; i++){
            if(nums[i]<tailTable[0]) tailTable[0]=nums[i]; // try new sequence
            else if(nums[i]>tailTable[n-1]) {
                tailTable[n]=nums[i];
                n++;
            } else { // in between, replace the ceiling of the current element
                int ceilIndex = binarySearchCeil(tailTable, 0, n-1, nums[i]);
                tailTable[ceilIndex]=nums[i];
            }
        }

        return n;
    }

    private int binarySearchCeil(int[] table, int l, int r, int target){
        while(l<r){
            int mid = l+(r-l)/2;

            if (table[mid]>=target) r=mid;
            else l=mid+1;
        }
        return r;
    }
}
// shorter version:
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = i + (j - i) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[j] = x;
            if (j == size) ++size;
        }
        return size;
    }
}
