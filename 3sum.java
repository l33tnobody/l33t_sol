public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        if (num.length<3) return res;
        
        Arrays.sort(num);
        for(int i=0;i<num.length-2;i++){
            if(i!=0&&num[i]==num[i-1]) continue; //avoid duplicates measures
            int j=i+1;
            int k=num.length-1;
            while(j<k){
                if(num[j]+num[k]>-num[i]) {k--;continue;}
                else if(num[j]+num[k]<-num[i]) {j++;continue;}              
                //found a match
                ArrayList<Integer> temp=new ArrayList<Integer>();
                temp.add(num[i]);temp.add(num[j]);temp.add(num[k]);
                res.add(temp);
                do{j++;}while(j<k&&num[j]==num[j-1]);
                do{k--;}while(j<k&&num[k]==num[k+1]); 
            } 
        }
        
        return res;
        
    }
}
