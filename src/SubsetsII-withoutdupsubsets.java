public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ret.add(new ArrayList<Integer>());
        
        int start = 0;
        for(int i = 0; i < num.length; i++){
            int size = ret.size();
            for(int j = start; j < size; j++){
                ArrayList<Integer> sub = new ArrayList<Integer>(ret.get(j));
                sub.add(num[i]);
                ret.add(sub);
            }
            if(i<num.length-1 && num[i+1]==num[i])  start=size;
            else start=0;
        }
        
        return ret;
    }
}
