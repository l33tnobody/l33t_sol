class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new LinkedList<>();
        int s = 0, e = 1;
        
        while(s < S.length()) {
            while(e < S.length() && S.charAt(e) == S.charAt(s)) e++;
            
            if(e - s >= 3) {
                List<Integer> toAdd = new LinkedList<>();
                toAdd.add(s); toAdd.add(e-1);
                res.add(toAdd);
            }
            s = e++;
        }
        
        return res;
    }
}

// or without the +1 for e
class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new LinkedList<>();
        int s = 0, e = 0;
        
        while(e < S.length()) {
            while(e < S.length() && S.charAt(e) == S.charAt(s)) e++;
            
            if(e - s >= 3) {
                List<Integer> toAdd = new LinkedList<>();
                toAdd.add(s); toAdd.add(e-1);
                res.add(toAdd);
            }
            s = e;
        }
        
        return res;
    }
}