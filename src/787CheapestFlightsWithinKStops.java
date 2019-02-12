class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] g = new int[n][n]; // graph
        for(int[] f : flights) {
            g[f[0]][f[1]] = f[2];
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[] start = new int[]{0, src, 0}; // cost, city, number of stops used: max K+1
        pq.offer(start);

        while(!pq.isEmpty()) {
            int[] t = pq.poll(); //min cost
            int cost = t[0], city = t[1], stops = t[2];
            if(t[1] == dst) return cost; // first min cost has to be the answer
            if(stops == K+1) continue;

            for(int i=0; i<n; i++) {
                if(g[city][i] > 0) pq.add(new int[]{ cost + g[city][i], i, stops + 1});
            }
        }

        return -1;
    }
}

// with dist[] optimize: (not necessary)
// class Solution {
//     public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
//         int[][] g = new int[n][n]; // graph
//         for(int[] f : flights) {
//             g[f[0]][f[1]] = f[2];
//         }

//         PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
//         int[] start = new int[]{0, src, 0}; // cost, city, number of stops used: max K+1
//         pq.offer(start);
//         int[] dist = new int[n];
//         Arrays.fill(dist, Integer.MAX_VALUE);
//         dist[src] = 0;

//         while(!pq.isEmpty()) {
//             int[] t = pq.poll(); //min cost
//             int cost = t[0], city = t[1], stops = t[2];
//             if(t[1] == dst) return cost;

//             dist[city] = cost;

//             if(stops == K+1) continue;

//             for(int i=0; i<n; i++) {
//                 if(g[city][i] > 0 && cost + g[city][i] < dist[i]) pq.add(new int[]{ cost + g[city][i], i, stops + 1});
//             }
//         }

//         return -1;
//     }
// }

// Bellman-Ford runs for K+1 times, time O(V*E)
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        //bellman - ford, run for k+1 stops
        int[] cost = new int[n];
        int INF = 0x3F3F3F3F; // not sure why this value not Integer.MAX_VALUE
        Arrays.fill(cost, INF);
        cost[src] = 0;

        for(int i=0; i<K+1; i++) { // up to number of vertices - 1, i.e. the longest path possible
            int[] C = cost.clone(); // make a copy based on the previous iteration array
            for(int[] e : flights) { // for each
                C[e[1]] = Math.min(C[e[1]], cost[e[0]] + e[2]);
            }
            cost = C;
        }

        return cost[dst] == INF ? -1 : cost[dst];
    }
}