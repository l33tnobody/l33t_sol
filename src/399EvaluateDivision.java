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

// Union Find: more efficient due to path compression in find, but harder to understand and implement, just for fun
public double[] calcEquation(String[][] equations, double[] values, String[][] query) {

        // map string to index in parent array
        Map<String, Integer> mIdTable = new HashMap<>();
        int len = 0;
        for (String[] words : equations)
            for (String word : words)
                if (!mIdTable.containsKey(word)) mIdTable.put(word, len++);

        // init parent index and value
        Node[] nodes = new Node[len];
        for (int i = 0; i < len; ++i) nodes[i] = new Node(i);

        // union, you can take an example as follows
        // consider: a/b, c/d: a and c are parents
        for (int i = 0; i < equations.length; ++i) {
            String[] keys = equations[i];
            int k1 = mIdTable.get(keys[0]);
            int k2 = mIdTable.get(keys[1]);
            int groupHead1 = find(nodes, k1);
            int groupHead2 = find(nodes, k2);
            nodes[groupHead2].parent = groupHead1;
            nodes[groupHead2].value = nodes[k1].value * values[i] / nodes[k2].value; // to get a/c = a/b * b/d / (c/d)
        }

        // query now
        double[] result = new double[query.length];
        for (int i = 0; i < query.length; ++i) {
            Integer k1 = mIdTable.get(query[i][0]);
            Integer k2 = mIdTable.get(query[i][1]);
            if (k1 == null || k2 == null) result[i] = -1d;
            else {
                int groupHead1 = find(nodes, k1);
                int groupHead2 = find(nodes, k2);
                if (groupHead1 != groupHead2) result[i] = -1d;
                else result[i] = nodes[k2].value / nodes[k1].value; // nodes[k2] and nodes[k1] are already compressed to parent: to get b/c: (a/c) / (a/b)
            }
        }
        return result;
    }

    public int find(Node[] nodes, int k) {
        int p = k;
        while (nodes[p].parent != p) {
            p = nodes[p].parent;
            // compress
            nodes[k].value *= nodes[p].value;
        }
        // compress
        nodes[k].parent = p;
        return p;
    }

    private static class Node {
        int    parent;
        double value;

        public Node(int index) {
            this.parent = index;
            this.value = 1d; // start with 1.0 a/a = 1.0
        }
    }
}