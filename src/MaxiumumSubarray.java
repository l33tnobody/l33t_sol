public class Solution {
    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int maxsum=A[0];
        int sum=A[0];
        
        for(int i=1;i<A.length;i++){
            if(sum<0)   sum=0;
            sum+=A[i];
            if(maxsum<sum)  maxsum=sum;
        }
        
        return maxsum;
    }
}
