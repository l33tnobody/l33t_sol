class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int[] parent = new int[accounts.size()];
        for(int i=0; i<parent.length; i++) parent[i] = i; //union by each account
        
        Map<String, Integer> map = new HashMap<>(); // from email to account to check dup email
        for(int i=0; i<accounts.size(); i++) {
            List<String> acc = accounts.get(i);
            for(int j=1; j<acc.size(); j++) {
                String email = acc.get(j);
                if(map.containsKey(email)) {
                    int pre_id = map.get(email);
                    int cur_id = i;
                    int parent_pre_id = find(parent, pre_id);
                    int parent_cur_id = find(parent, cur_id);
                    if(parent_pre_id != parent_cur_id) {
                        parent[parent_cur_id] = parent_pre_id;
                    }
                } else {
                    map.put(email, i);
                }
            }
        }
        
        Map<Integer, Set<String>> ppl = new HashMap<>(); // a person and its unique emails
        for(int i=0; i<accounts.size(); i++) { // squash all emails to the final parent/a.k.a a person
            int p = find(parent, i);
            if(!ppl.containsKey(p)) ppl.put(p, new HashSet<>());
            
            List<String> acc = accounts.get(i);
            for(int j=1; j<acc.size(); j++) ppl.get(p).add(acc.get(j));
        }
        
        List<List<String>> res = new ArrayList<>();
        for(int id : ppl.keySet()) {
            List<String> entry = new ArrayList<>();
            entry.add(accounts.get(id).get(0)); // name
            
            List<String> addemails = new ArrayList<>(ppl.get(id));
            Collections.sort(addemails);
            entry.addAll(addemails);
            
            res.add(entry);
        }
        
        return res;
    }
    
    private int find(int[] parent, int i) {
        if(parent[i] != i) parent[i] = find(parent, parent[i]);
        return parent[i];
    }
}