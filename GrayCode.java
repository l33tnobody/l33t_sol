public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int max = 1<<n;
        ArrayList<Integer> res= new ArrayList<Integer>();
        for(int i=0; i<max; i++){
            res.add(i^(i>>1));
        }
        return res;
    }
}
