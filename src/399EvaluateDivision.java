// graph DFS, using hashmap as adj list
class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> m = new HashMap<>();
        for(int i=0; i<equations.length; i++) {
            String[] e = equations[i];
            insert(m, e[0], e[1], values[i]);
            insert(m, e[1], e[0], 1.0 / values[i]);
        }
        
        double[] res = new double[queries.length];
        for(int i=0; i<queries.length; i++) {
            String[] q = queries[i];
            if(!m.containsKey(q[0]) || !m.containsKey(q[1])) res[i] = -1.0; // no such key
            else if(q[0] == q[1]) res[i] = 1.0;
            else {
                Double ret = handleQuery(q[0], q[1], m, new HashSet<String>());
                res[i] = ret == null ? -1.0 : ret;
            }
        }
        
        return res;
    }
    
    private void insert(Map<String, Map<String, Double>> m, String src, String dest, double value) {
        Map<String, Double> mm = m.get(src);
        if(mm == null) {
            mm = new HashMap<>();
            m.put(src, mm);
        }
        mm.put(dest, value);
    }
    
    private Double handleQuery(String src, String dest, Map<String, Map<String, Double>> m, Set<String> visited) { // DFS
        Map<String, Double> mm = m.get(src);
        if(mm.containsKey(dest)) return mm.get(dest); // little optimization to check directly existing pairs
        
        visited.add(src);
        for(String k : mm.keySet()) {
            if(visited.contains(k)) continue;
            Double ret = handleQuery(k, dest, m, visited);
            if(ret != null) return mm.get(k) * ret;
        }
        visited.remove(src);
        return null;
    }
}