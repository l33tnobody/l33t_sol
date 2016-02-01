public class Solution {
    public int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n=num.length;
        assert n>=3;
        Arrays.sort(num);
        int cs=num[0]+num[1]+num[num.length-1];
        
        for(int i=0;i<num.length-2;i++){
            int j=i+1;
            int k=num.length-1;
            while(j<k){
                int tempsum=num[i]+num[j]+num[k];
                if(Math.abs(tempsum-target)<Math.abs(cs-target)) cs=tempsum;
                if(cs==target) return cs;
                
                if(tempsum>target) k--;
                else j++;
            }
        }
        return cs;
    }
}
