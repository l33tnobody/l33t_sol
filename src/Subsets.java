public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        int max=1<<S.length;    //2^n
        for(int i=0; i<max; i++){
            ArrayList<Integer> subset = convBitToSet(i, S);
            res.add(subset);
        }
        return res;
    }
    
    private ArrayList<Integer> convBitToSet(int bitmap, int[] S){
        ArrayList<Integer> subset = new ArrayList<Integer>();
        
        for(int index=0; bitmap>0; bitmap>>=1, index++){
            if((bitmap&1) == 1){
                subset.add(S[index]);
            }
        }
        
        return subset;
    }
}
