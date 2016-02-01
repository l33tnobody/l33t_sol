public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(candidates == null || candidates.length == 0) return res;

        Arrays.sort(candidates);
        comboSum2(candidates, 0, target, 0, new ArrayList<Integer>(), res);
        return res;
    }

    private void comboSum2(int[] candidates, int sum,  int target, int pos, ArrayList<Integer> pRes, ArrayList<ArrayList<Integer>> res){

        for(int i= pos; i< candidates.length; i++){
            if(i>pos&&candidates[i]==candidates[i-1])    continue; //get rid of dups

            int curnum=candidates[i];
            pRes.add(curnum);
            sum+=curnum;
            if(sum == target)
                res.add(new ArrayList<Integer>(pRes));
            else if (sum < target){
                comboSum2(candidates, sum, target, i+1, pRes, res);
                pRes.remove(pRes.size()-1);
                sum-=curnum;
                continue;
            } //else sum>target and sum==target, remove last number in result and break
            pRes.remove(pRes.size()-1);
            sum-=curnum;
            break;
        }
    }
}

// better:

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> running = new ArrayList<Integer>();
        Arrays.sort(candidates);
        comboHelper(candidates, target, 0, running, res);
        return res;
    }

    private void comboHelper(int[] candidates, int target, int pos, ArrayList<Integer> running, List<List<Integer>> res){
        if (target==0){
            res.add(new ArrayList<Integer>(running));
            return;
        }

        for(int i=pos;i<candidates.length;i++){
            if (target<candidates[i])
                break;
            if (i>pos&&candidates[i]==candidates[i-1]) //remove dup
                continue;

            running.add(candidates[i]);
            comboHelper(candidates, target-candidates[i], i+1, running, res);
            running.remove(running.size()-1);
        }
    }
}
