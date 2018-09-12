// n^2 solution using cumulative sum and hashset
class Solution {
    // the question is essentially asking to cut array with i, j, k
    // 0, i, i+1, j, j+1, k, n-1, strictly greater than relations
    public boolean splitArray(int[] nums) {
        int n = nums.length;
        if(n < 7) return false;
        int[] presum = new int[n];
        presum[0] = nums[0];
        for(int i=1; i<n; i++) {
            presum[i] = presum[i-1] + nums[i];
        }
        // cut with j in the middle first
        for(int j = 3; j < n-3; j++) {
            Set<Integer> set = new HashSet<>();
            for(int i=1; i <= j-2; i++) { // cut with i
                if(presum[i-1] == presum[j-1]-presum[i]) set.add(presum[i-1]);
            }
            for(int k=j+2; k<n-1; k++) {
                if(presum[k-1] - presum[j] == presum[n-1] - presum[k] && set.contains(presum[n-1] - presum[k])) return true;
            }
        }
        
        return false;
    }
}

// n^3 solution using cumulative sum: TLE
class Solution {
    // the question is essentially asking to cut array with i, j, k
    // 0, i, i+1, j, j+1, k, n-1, strictly greater than relations
    public boolean splitArray(int[] nums) {
        int n = nums.length;
        if(n < 7) return false;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for(int i=1; i<n; i++) {
            sum[i] = sum[i-1] + nums[i];
        }
        
        for(int i=1; i<n-5; i++) {
            int sum1 = sum[i-1];
            for(int j=i+2; j<n-3; j++) {
                int sum2 = sum[j-1] - sum[i];
                if(sum2 != sum1) continue;
                
                for(int k=j+2; k<n-1; k++) {
                    int sum3 = sum[k-1] - sum[j];
                    if(sum3 != sum2) continue;
                    
                    int sum4 = sum[n-1] - sum[k];
                    if(sum4 == sum3) return true;
                }
            }
        }
        
        return false;
    }
}
