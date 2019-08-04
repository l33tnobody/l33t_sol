// checking pairs
public class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        int n = org.length;
        int[] index = new int[n+1];
        for(int i=0; i<org.length; i++) {
            index[org[i]] = i;
        }

        int countMatched = 0;
        boolean[] match = new boolean[n]; // default to all false
        int countMentioned = 0;
        boolean[] mentioned = new boolean[n+1]; // all 1 ~ n integers need to be mentioned
        for(List<Integer> l : seqs) {
            for(int i=0; i<l.size(); i++) {
                int p = l.get(i);
                if(p < 1 || p > n) return false;
                if (!mentioned[p]) {
                    mentioned[p] = true;
                    countMentioned++;
                }

                if (i == 0) continue;

                int q = l.get(i-1);
                int x = index[q];
                int y = index[p];
                if (x >= y) return false;

                if (y == x + 1 && !match[x]) {
                    match[x] = true;
                    countMatched++;
                }
            }
        }

        return countMatched == n-1 && countMentioned == n;
    }
}

// using graph. check indegree one node at a time
public class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        int n = org.length;

        // build graph
        for(List<Integer> l : seqs) {
            for(int i=0; i<l.size(); i++) {
                int u = l.get(i);
                if(u < 1 || u > n) return false;
                if(!adj.containsKey(u)) adj.put(u, new HashSet<>());
                if(!indegree.containsKey(u)) indegree.put(u, 0);

                if(i == 0) continue;

                int v = l.get(i-1);
                if(adj.get(v).add(u)) { // avoid duplicate indegree count from the same node
                    indegree.put(u, indegree.get(u) + 1);
                }
            }
        }

        // check initial indegree
        int countZeroIn = 0;
        for(int d : indegree.values()) { if(d == 0 ) countZeroIn++; }
        if(countZeroIn != 1) return false;

        // check topological order
        for(int i=0; i<org.length; i++) {
            int u = org[i];
            if(!indegree.containsKey(u) || indegree.get(u) != 0) return false;

            // remove u from graph
            for(int v : adj.get(u)) {
                int d = indegree.get(v) - 1;
                if (d == 0 && v != org[i+1]) return false;
                indegree.put(v, d);
            }
        }

        return true;
    }
}
