// recursive:
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> running = new ArrayList<>();

        helper(res, running, n, k, 1);

        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> running, int n, int k, int s) {
        if (k == 0) {
            res.add(new ArrayList<Integer>(running));
            return;
        }

        for(int i=s; i<=n+1-k; i++) {
            running.add(i);
            helper(res, running, n, k-1, i+1);
            running.remove(running.size() - 1);
        }
    }
}

// iterative:
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();

        if (k <= 0 || k > n) return res;

        res.add(new ArrayList<Integer>());
        for(int i=1; i<=k; i++) {
            List<List<Integer>> newres = new ArrayList<>();

            for(List<Integer> temp:res) {
                int a=0;
                if(temp.size()>0) a=temp.get(temp.size()-1);
                for(int j=a+1; j<=n-k+i; j++) {
                    List<Integer> b = new ArrayList<Integer>(temp);
                    b.add(j);
                    newres.add(b);
                }
            }
            res = newres;
        }

        return res;
    }
}
