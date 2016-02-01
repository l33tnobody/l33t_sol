public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
        
        for(int i=0; i<numbers.length; i++){
            if (hm.containsKey(numbers[i])){
                int[] res = new int[2];
                res[0] = hm.get(numbers[i]) + 1;
                res[1] = i + 1;
                return res;
            }
            
            hm.put(target-numbers[i], i);   
        }
        
        //if not found
        int[] res_notfound = new int[2];
        res_notfound[0] = res_notfound[1] = -1;
        return res_notfound;
    }
}
