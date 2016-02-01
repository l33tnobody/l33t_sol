public class Solution {
    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        ArrayList<Integer> res=new ArrayList<Integer>();
        for(int i: digits)  res.add(i);
        
        int i=res.size()-1;
        for(;i>=0;i--){
            if(res.get(i)!=9){
                Integer newInt=new Integer(res.get(i).intValue()+1);
                res.set(i,newInt);
                return conv(res);
            }
            res.set(i, new Integer(0));
        }
        res.add(0, 1);
        return conv(res);
    }
    
    private int[] conv(ArrayList<Integer> A){
        int[] res=new int[A.size()];
        for(int i=0; i<A.size(); i++){res[i]=A.get(i);}
        return res;
    }
}
