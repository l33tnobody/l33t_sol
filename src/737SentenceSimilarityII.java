// dfs:
class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;
        
        Map<String, Set<String>> pairInfo = new HashMap<>();
        
        for (String[] pair : pairs) {
            if (!pairInfo.containsKey(pair[0])) pairInfo.put(pair[0], new HashSet<>());
            if (!pairInfo.containsKey(pair[1])) pairInfo.put(pair[1], new HashSet<>());
            pairInfo.get(pair[0]).add(pair[1]);
            pairInfo.get(pair[1]).add(pair[0]);
        }
        
        for (int i = 0; i < words1.length; i++) {
            if (words1[i].equals(words2[i])) continue;
            if (!pairInfo.containsKey(words1[i]) || !pairInfo.containsKey(words2[i]))
                return false;
            if(!dfs(words1[i], words2[i], pairInfo, new HashSet<>())) return false;
        }
        
        return true;
    }
    
    private boolean dfs(String src, String target, Map<String, Set<String>> pairInfo, Set<String> visited) {
        if(pairInfo.get(src).contains(target)) return true;
        
        visited.add(src);
        for(String next : pairInfo.get(src)) {
            if(visited.contains(next)) continue;
            if(dfs(next, target, pairInfo, visited)) return true;
        }
        return false;
    }
}


// union find solution:
class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;
        Map<String, String> parents = new HashMap<>();
        
        for (String[] p : pairs) {
            if(!parents.containsKey(p[0])) parents.put(p[0], p[0]);
            if(!parents.containsKey(p[1])) parents.put(p[1], p[1]);
            parents.put(find(parents, p[0]), find(parents, p[1])); // union
        }
        
        for(int i=0; i<words1.length; i++) {
            if(words1[i].equals(words2[i])) continue;
            if(!parents.containsKey(words1[i]) || !parents.containsKey(words2[i])) return false;
            if(!find(parents, words1[i]).equals(find(parents, words2[i]))) return false;
        }
        
        return true;
    }
    
    private String find(Map<String, String> parents, String s){
        if(!parents.get(s).equals(s)) parents.put(s, find(parents, parents.get(s)));
        return parents.get(s);
    }
}