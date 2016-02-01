public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n=num.length;
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        if(n<4) return res;
        
        Arrays.sort(num);
        for(int i=0;i<n-3;i++){
            if (i!=0&&num[i]==num[i-1]) continue;
            for(int j=i+1;j<n-2;j++){
                if(j!=i+1&&num[j]==num[j-1]) continue;
                int k=j+1;
                int l=n-1;
                while(k<l){
                    if(num[i]+num[j]+num[k]+num[l]>target){do{l--;} while(k<l&&num[l]==num[l+1]); continue;}//l-- optimized
                    if(num[i]+num[j]+num[k]+num[l]<target){do{k++;} while(k<l&&num[k]==num[k-1]); continue;}//k++ optimized
                    //found
                    ArrayList<Integer> temp=new ArrayList<Integer>();
                    temp.add(num[i]);temp.add(num[j]);temp.add(num[k]);temp.add(num[l]);
                    res.add(temp);
                    do{k++;} while(k<l&&num[k]==num[k-1]);
                    do{l--;} while(k<l&&num[l]==num[l+1]);
                }
            }
        }
        return res;
        
    }
}
