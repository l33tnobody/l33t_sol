// use a relative count for relative number of 0 and 1 and use a map to record the earlist occurence of count (index)
class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // map from relative count between (0, 1) to its earliest index
        map.put(0, -1);
        int count = 0, maxlen = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 1) count++;
            else count--;
            
            if(map.containsKey(count)) maxlen = Math.max(maxlen, i - map.get(count));
            else map.put(count, i);
        }
        
        return maxlen;
    }
}