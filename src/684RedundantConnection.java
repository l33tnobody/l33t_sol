class Solution {
    int MAX_EDGE = 2001;
    
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(MAX_EDGE);
        for(int[] e : edges) {
            if(uf.find(e[0]) == uf.find(e[1])) return e;
            else uf.union(e[0], e[1]);
        }
        
        return new int[2]; // throw new AssertionError();
    }
    
    class UnionFind {
        int[] parent;
        
        public UnionFind(int maxedge) {
            parent = new int[maxedge];
            for(int i = 0; i < maxedge; i++) parent[i] = i;
        }
        
        public int find (int x){
            if(parent[x] != x) parent[x] = find(parent[x]);
            
            return parent[x];
        }
        
        public void union(int x, int y){
            parent[find(x)] = find(y);
        }
    }

    /* union by rank 
    class UnionFind {
        int[] parent;
        int[] rank;
        
        public UnionFind(int size) {
            parent = new int[size];
            for(int i = 0; i < size; i++) parent[i] = i;
            rank = new int[size];
        }
        
        public int find (int x){
            if(parent[x] != x) parent[x] = find(parent[x]);
            
            return parent[x];
        }
        
        public void union(int x, int y){
            int px = find(x), py = find(y);
            if(px == py) return;
            
            if(rank[px] < rank[py]) parent[px] = py;
            else if(rank[px] > rank[py]) parent[py] = px;
            else {
                parent[px] = py;
                rank[py]++;
            }
        }
    }
    */
}