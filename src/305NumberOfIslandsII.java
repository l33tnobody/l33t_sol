// built-in union-find
public class Solution {
    int[][] neighbors = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<Integer>();
        int[] parent = new int[m*n];
        Arrays.fill(parent, -1);
        int count = 0;

        for(int[] pos : positions) {
            int x = pos[0];
            int y = pos[1];
            int index = x*n + y;
            parent[index] = index;
            count++;

            for(int[] nb : neighbors) {
                int p = x + nb[0];
                int q = y + nb[1];
                int indexnb = p*n + q;

                if(p>=0 && p<m && q>=0 && q<n && parent[indexnb] != -1) {
                    int root = find(parent, index);
                    int rootnb = find(parent, indexnb);
                    if(root != rootnb) {
                        parent[root] = rootnb;
                        count--;
                    }
                }
            }
            res.add(count);
        }

        return res;
    }

    private int find(int[] parent, int i) {
        if(parent[i] == i) return i;

        parent[i] = find(parent, parent[i]);
        return parent[i];
    }
}

// union-find class using parent array for tracking
public class Solution {
   class UnionFind {
        int[] parent;
        int count;

        UnionFind(int cap) {
            parent = new int[cap];
            Arrays.fill(parent, -1);
            count = 0;
        }

        public void set(int i) {
            parent[i] = i;
            count++;
        }

        public boolean isSet(int i) {
            return parent[i] != -1;
        }

        public void union(int index1, int index2) {
            int p1 = find(index1);
            int p2 = find(index2);
            if (p1 != p2) {
                parent[p1] = p2;
                count--;
            }
        }

        public int find(int index) {
            if(parent[index] == index) return index;
            // path compression
            parent[index] = find(parent[index]);
            return parent[index];
        }

        public int getCount() {
            return count;
        }
    }

    int[][] neighbors = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<Integer>();
        UnionFind uf = new UnionFind(m*n);

        for(int[] pos : positions) {
            int x = pos[0];
            int y = pos[1];
            int index = x*n + y;

            uf.set(index);

            for(int[] nb : neighbors) {
                int p = x + nb[0];
                if (p < 0 || p >= m ) continue;
                int q = y + nb[1];
                if (q < 0 || q >= n ) continue;

                int indexnb = p*n + q;

                if(uf.isSet(indexnb)) uf.union(index, indexnb);
            }
            res.add(uf.getCount());
        }

        return res;
    }
}

public class Solution {
    class UnionFind {
        int[] parent;
        int count;
        int rows, cols;

        UnionFind(int m, int n) {
            parent = new int[n*m];
            count = 0;
            rows = m;
            cols = n;
        }

        public void set(int i, int j) {
            int index = i*cols + j;
            parent[index] = index;
            count++;
        }

        public void union(int index1, int index2) {
            int p1 = find(index1);
            int p2 = find(index2);
            if (p1 != p2) {
                parent[p1] = p2;
                count--;
            }
        }

        public int find(int index) {
            if(parent[index] == index) return index;
            // path compression
            parent[index] = find(parent[index]);
            return parent[index];
        }

        public int getCount() {
            return count;
        }
    }

    int[][] neighbors = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<Integer>();
        int[][] grid = new int[m][n];
        UnionFind uf = new UnionFind(m, n);

        for(int[] pos : positions) {
            int x = pos[0];
            int y = pos[1];

            grid[x][y] = 1;
            uf.set(x, y);

            for(int[] nb : neighbors) {
                int p = x + nb[0];
                int q = y + nb[1];

                if(p>=0 && p<m && q>=0 && q<n && grid[p][q] == 1) uf.union(x*n + y, p*n + q);
            }
            res.add(uf.getCount());
        }

        return res;
    }
}
