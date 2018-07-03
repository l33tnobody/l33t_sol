class Solution {
    public int numSimilarGroups(String[] A) {
        int n = A.length;
        UnionFind uf = new UnionFind(n);
        
        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                if(similar(A[i], A[j])) uf.union(i, j);
            }
        }
        
        return uf.size;
    }
    
    private boolean similar(String a, String b) {
        int count = 0;
        for(int i=0; i<a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) {
                if(++count > 2) return false;
            }
        }
        return true; // stays at 2 difference
    }
    
    class UnionFind {
        int parents[];
        int size;
        
        public UnionFind(int n) {
            parents = new int[n];
            for(int i=0; i<n; i++) parents[i] = i;
            size = n;
        }
        
        public int find(int i) {
            if(parents[i] != i) parents[i] = find(parents[i]);
            return parents[i];
        }
        
        public void union(int i, int j) {
            int pi = find(i), pj = find(j);
            
            if(pi != pj) {
                parents[pi] = pj;
                size--;
            }
        }
    }
}

/* with rank based union
class UnionFind {
        int parents[];
        int rank[];
        int size;
        
        public UnionFind(int n) {
            parents = new int[n];
            for(int i=0; i<n; i++) parents[i] = i;
            rank = new int[n];
            size = n;
        }
        
        public int find(int i) {
            if(parents[i] != i) parents[i] = find(parents[i]);
            return parents[i];
        }
        
        public void union(int i, int j) {
            int pi = find(i), pj = find(j);
            
            if(pi == pj) return;
            
            size--;
            if(rank[pi] < rank[pj]) {
                parents[pi] = pj;
            } else if (rank[pi] > rank[pj]) {
                parents[pj] = pi;
            } else {
                parents[pi] = pj;
                rank[pj]++;
            }
        }
    }
*/