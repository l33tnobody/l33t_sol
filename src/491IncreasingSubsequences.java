class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> running = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        recurFind(res, running, 0, nums);

        return res;
    }

    private void recurFind(List<List<Integer>> res, List<Integer> running, int j, int[] nums) {
        int len = running.size();
        if (len >= 2) res.add(new ArrayList<>(running));

        Set<Integer> used = new HashSet<>();

        for (int i=j; i<nums.length; i++) {
            if(used.contains(nums[i]) || (len > 0 && running.get(len-1) > nums[i])) continue;
            used.add(nums[i]);
            running.add(nums[i]);
            recurFind(res, running, i+1, nums);
            running.remove(len);
        }
    }
}


// interative, just for reference:
class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>(); // to deduplicate
        res.add(new ArrayList<Integer>());

        for (int i=0; i<nums.length; i++) {
            Set<List<Integer>> newres = new HashSet<>();
            newres.addAll(res);
            for(List<Integer> l : res) {
                if (l.size() > 0 && l.get(l.size()-1) > nums[i]) continue;
                List<Integer> newl = new ArrayList<>(l);
                newl.add(nums[i]);
                newres.add(newl);
            }
            res = newres;
        }

        List<List<Integer>> reslist = new ArrayList<>();
        for(List<Integer> l : res) {
            if (l.size() >= 2)
                reslist.add(l);
        }

        return reslist;
    }
}
