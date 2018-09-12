// an easier to understand version:
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(new ArrayList<Integer>());
        
        for(int i = 0; i < nums.length; ) {
            int size = ret.size();
            int j = i+1;
            while(j<nums.length && nums[j] == nums[j-1]) j++;
            int count = j - i; // num of dups
            
            for(int k=0; k<size; k++) {
                List<Integer> l = new ArrayList<>(ret.get(k));
                for(int c=0; c<count; c++){
                    l.add(nums[i]);
                    ret.add(new ArrayList<>(l));
                }
            }
            
            i += count;
        }
        
        return ret;
    }
}

// corresponding backtracking version:
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> running  = new ArrayList<>();

        helper(res, nums, 0, running);

        return res;
    }
    
    private void helper(List<List<Integer>> res, int[] nums, int index, List<Integer> running) {
        if(index == nums.length) {
            res.add(new ArrayList(running));
            return;
        }

        int j = index + 1;
        while(j<nums.length && nums[j] == nums[j-1]) j++;
        int count = j - index; // num of dups
        
        helper(res, nums, index+count, running); // add 0 current element

        for(int c=0; c<count; c++) {
            running.add(nums[index]);
            helper(res, nums, index+count, running);
        }
        
        for(int c=0; c<count; c++) { running.remove(running.size() - 1); }
    }
}

// older iterative version:
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(new ArrayList<Integer>());
        
        int start = 0;
        for(int i = 0; i < nums.length; i++){
            int size = ret.size();
            for(int j = start; j < size; j++){
                List<Integer> sub = new ArrayList<>(ret.get(j));
                sub.add(nums[i]);
                ret.add(sub);
            }
            if(i < nums.length-1 && nums[i+1] == nums[i])  start=size;
            else start=0;
        }
        
        return ret;
    }
}