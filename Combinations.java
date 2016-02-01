public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(k<=0||k>n) return res;
        
        res.add(new ArrayList<Integer>());
        for(int i=1;i<=k;i++){
            ArrayList<ArrayList<Integer>> newres = new ArrayList<ArrayList<Integer>>();
            
            for(ArrayList<Integer> temp:res){
                int a=0;
                if(temp.size()>0)   a=temp.get(temp.size()-1);
                for(int j=a+1;j<=n-k+i;j++){
                    ArrayList<Integer> b = new ArrayList<Integer>(temp);
                    b.add(j);
                    newres.add(b);
                }
            }
            res = newres;
        }
        
        return res;
    }
}
