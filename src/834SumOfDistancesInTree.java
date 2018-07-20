// O(n^2) is trivial dfs every node as root level by level and do sum

// O(n) just for fun: will need to rely on the reference formula
// calculate partial count and res first for each subtree
// https://leetcode.com/problems/sum-of-distances-in-tree/discuss/130583/C++JavaPython-Pre-order-and-Post-order-DFS-O(N)
/*
Explanation:
0. Let's solve it with node 0 as root.

1. Initial an array of hashset tree, tree[i] contains all connected nodes to i.
Initial an array count, count[i] counts all nodes in the subtree i.
Initial an array of res, res[i] counts sum of distance in subtree i.

2. Post order dfs traversal, update count and res:
count[root] = sum(count[i]) + 1
res[root] = sum(res[i]) + sum(count[i])

3. Pre order dfs traversal, update res:
When we move our root from parent to its child i, count[i] points get 1 closer to root, n - count[i] nodes get 1 futhur to root.
res[i] = res[root] - count[i] + N - count[i]

4. return res, done.
*/
class Solution {
    int[] res, count; 
    ArrayList<HashSet<Integer>> tree;
    int n;
    
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        tree = new ArrayList<HashSet<Integer>>();
        res = new int[N];
        count = new int[N]; // count of number of nodes in the subtree with root i, finally rooted at 0
        n = N;
        for (int i = 0; i < N ; i++ ) tree.add(new HashSet<Integer>());
        for (int[] e : edges) { tree.get(e[0]).add(e[1]); tree.get(e[1]).add(e[0]); }
        dfs(0, new HashSet<Integer>()); // get partial count and partial of res ready (res[0] is ready afterwards)
        dfs2(0, new HashSet<Integer>()); // transitively calculate all res with the reference formula
        return res;
    }
    
    public void dfs(int root, HashSet<Integer> seen) {
        seen.add(root);
        for (int i : tree.get(root)) {
            if (!seen.contains(i)) {
                dfs(i, seen);
                count[root] += count[i];
                res[root] += res[i] + count[i];
            }
        }
        count[root]++;
    }
    
    public void dfs2(int root, HashSet<Integer> seen) {
        seen.add(root);
        for (int i : tree.get(root)) {
            if (!seen.contains(i)) {
                res[i] = res[root] - count[i] + n - count[i]; // the reference formula
                dfs2(i, seen);
            }
        }
    }
}