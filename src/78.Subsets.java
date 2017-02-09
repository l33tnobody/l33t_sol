// bitmap solution
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        int max = 1 << nums.length;
        for(int i = 0; i < max; i++) {  // i is bitmap
            res.add(convert(nums, i));
        }

        return res;
    }

    private List<Integer> convert(int[] nums, int i) {
        List<Integer> l = new ArrayList<>();

        for(int index = 0; i > 0; index++, i>>=1) {
            if ((i & 1) == 1) l.add(nums[index]);
        }

        return l;
    }
}

// recursion on exclude or include:
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
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

        helper(res, nums, index+1, running);

        running.add(nums[index]);
        helper(res, nums, index+1, running);
        running.remove(running.size() - 1);
    }
}


//iterative solution:
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());

        for(int i = 0; i < nums.length; i++) {
            List<List<Integer>> newres = new ArrayList<>();
            for(List l : res) {
                newres.add(l);
                List<Integer> newl = new ArrayList(l);
                newl.add(nums[i]);
                newres.add(newl);
            }
            res = newres;
        }

        return res;
    }
}
