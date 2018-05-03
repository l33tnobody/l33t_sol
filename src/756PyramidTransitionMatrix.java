class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : allowed) {
            String key = s.substring(0, 2);
            if(!map.containsKey(key)) map.put(key, new ArrayList<String>());
            map.get(key).add(s.substring(2));
        }
        return dfs(bottom, 0, "", map);
    }

    private boolean dfs(String bottom, int idx, String upper, Map<String, List<String>> map) {
        if(bottom.length() == 1) return true;

        if(idx == bottom.length() - 1) {
            return dfs(upper, 0, "", map);
        }

        if(idx == 0) { // check if allowed rules to save recursion effort and return false early
            for(int i=0; i<bottom.length()-1; i++) {
                if(!map.containsKey(bottom.substring(i, i+2))) return false;
            }
        }

        for(String s : map.get(bottom.substring(idx, idx+2))) {
            if(dfs(bottom, idx+1, upper+s, map)) return true;
        }

        return false;
    }
}
