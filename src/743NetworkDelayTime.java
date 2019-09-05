// problem is asking to find the max of all shortest paths
// Dijkstra: using a Heap to greedily pull the smallest and a map to
// record the shortest path vertex, value
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> g = new HashMap<>(); // graph adjacency list
        for(int[] e : times) {
            int u = e[0], v = e[1], w = e[2];
            if(!g.containsKey(u)) g.put(u, new ArrayList<>());
            g.get(u).add(new int[]{v, w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // heap to pull current smallest distance
        pq.offer(new int[]{K, 0});
        Map<Integer, Integer> dist = new HashMap<>();
        int res = 0;

        while(!pq.isEmpty()) {
            int[] p = pq.poll();
            int u = p[0], d = p[1];
            if(dist.containsKey(u)) continue;
            dist.put(u, d);
            res = d; // d is always increasing due to non negtive edge, or we can iterate over dist values afterwards to get the max

            if(g.containsKey(u)) {
                for(int[] e : g.get(u)) {
                    if(dist.containsKey(e[0])) continue;
                    pq.offer(new int[]{ e[0], d+e[1] });
                }
            }
        }

        if(dist.size() != N) return -1; // not all nodes can be reached from K

        return res;
    }
}

// Bellman-Ford:
// O(VE)
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        int[] a = new int[1 + N];
        Arrays.fill(a, Integer.MAX_VALUE);
        a[K] = 0;

        for (int i = 0; i < N; i++) { // N times, node number is not important here
            int[] newa = a.clone(); // get a new array for adding a stop in the path, special case when N stops, no need to clone, since any path > N will have loops which will not be min distance

            for (int[] e : times) {
                int u = e[0], v = e[1], w = e[2];
                if (a[u] != Integer.MAX_VALUE) {
                    if (newa[v] > a[u] + w)
                        newa[v] = a[u] + w;
                }
            }
            a = newa;
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, a[i]);
        }

        return (max == Integer.MAX_VALUE) ? -1 : max;
    }
}