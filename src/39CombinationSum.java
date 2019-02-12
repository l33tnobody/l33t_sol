// back tracing is better than dp in this case where the question requires
// no duplicate combinations like [2,2,3], [3,2,2]. [2,3,2]
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> running = new ArrayList<>();
        Arrays.sort(candidates);
        comboHelper(candidates, target, 0, running, res);
        return res;
    }

    private void comboHelper(int[] candidates, int target, int pos, List<Integer> running, List<List<Integer>> res) {
        if (target==0) {
            res.add(new ArrayList<Integer>(running));
            return;
        }

        for(int i=pos; i<candidates.length; i++) {
            if (target < candidates[i])
                break;

            // the question said no duplicates now
            // if (i>pos && candidates[i] == candidates[i-1]) //remove dup
            //     continue;

            running.add(candidates[i]);
            comboHelper(candidates, target-candidates[i], i, running, res);
            running.remove(running.size()-1);
        }
    }
}




// FYI: a ordered dp approach:
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> running = new ArrayList<>();
        // Arrays.sort(candidates);
        List<List<List<Integer>>> mem = new ArrayList<List<List<Integer>>>(target + 1);

        mem.add(new ArrayList<>());
        mem.get(0).add(new ArrayList<Integer>()); // add empty list for 0

        for(int i=1; i<=target; i++) {
            mem.add(new ArrayList<List<Integer>>());
            for(int c : candidates) {
                if(c <= i) {
                    for(List<Integer> l : mem.get(i - c)) {
                        if(l.isEmpty() || c >= l.get(l.size()-1) ) {
                            List<Integer> lnew = new ArrayList<Integer>(l);
                            lnew.add(c);
                            mem.get(i).add(lnew);
                        }
                    }
                }
            }
        }


        return mem.get(target);
    }
}

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> running = new ArrayList<>();
        // Arrays.sort(candidates);
        List<List<List<Integer>>> mem = new ArrayList<List<List<Integer>>>(target + 1);

        for(int i=0; i<=target; i++) { mem.add(null); }
        mem.set(0, new ArrayList<>());
        mem.get(0).add(new ArrayList<Integer>()); // add empty list for 0

        return comboHelper(candidates, target, mem);
    }

    private List<List<Integer>> comboHelper(int[] candidates, int target, List<List<List<Integer>>> mem) {
        if(mem.get(target) != null) return mem.get(target);

        mem.set(target, new ArrayList<List<Integer>>());
        for(int c : candidates) {
            if(c <= target) {
                for(List<Integer> l : comboHelper(candidates, target - c, mem)) {
                    if(l.isEmpty() || c >= l.get(l.size()-1) ) { // put order here to eliminate dups [2,2,3], [3,2,2]. [2,3,2]
                        List<Integer> lnew = new ArrayList<Integer>(l);
                        lnew.add(c);
                        mem.get(target).add(lnew);
                    }
                }
            }
        }
        return mem.get(target);
    }
}