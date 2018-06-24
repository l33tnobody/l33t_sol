// just for fun:
// this question might be too much if description accurate
/*
There are 3 cases:

    No loop, but there is one node who has 2 parents.
    A loop, and there is one node who has 2 parents, that node must be inside the loop.
    A loop, and every node has only 1 parent.

    Case 1: e.g. [[1,2],[1,3],[2,3]] ,node 3 has 2 parents ([1,3] and [2,3]). Return the edge that occurs last that is, return [2,3].
    Case 2: e.g. [[1,2],[2,3],[3,1],[4,1]] , {1->2->3->1} is a loop, node 1 has 2 parents ([4,1] and [3,1]). Return the edge that is inside the loop, that is, return [3,1].
    Case 3: e.g. [[1,2],[2,3],[3,1],[1,4]] , {1->2->3->1} is a loop, you can remove any edge in a loop, the graph is still valid. Thus, return the one that occurs last, that is, return [3,1].
*/
// https://leetcode.com/problems/redundant-connection-ii/discuss/108045/C++Java-Union-Find-with-explanation-O(n)

class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] can1 = {-1, -1};
        int[] can2 = {-1, -1};
        int[] parent = new int[edges.length + 1];
        for (int i = 0; i < edges.length; i++) {
            if (parent[edges[i][1]] == 0) {
                parent[edges[i][1]] = edges[i][0];
            } else {
                can2 = new int[] {edges[i][0], edges[i][1]};
                can1 = new int[] {parent[edges[i][1]], edges[i][1]};
                edges[i][1] = 0;
            }
        }
        for (int i = 0; i < edges.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][1] == 0) {
                continue;
            }
            int child = edges[i][1], father = edges[i][0];
            if (root(parent, father) == child) {
                if (can1[0] == -1) {
                    return edges[i];
                }
                return can1;
            }
            parent[child] = father;
        }
        return can2;
    }
    
    int root(int[] parent, int i) {
        while (i != parent[i]) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }   
        return i;
    }
}