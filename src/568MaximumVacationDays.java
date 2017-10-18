// Will timeout!: dfs: O(N^(K+1)) will TLE
public class Solution {
    int max = 0, N = 0, K = 0;

    public int maxVacationDays(int[][] flights, int[][] days) {
        N = flights.length;
        K = days[0].length;
        dfs(flights, days, 0, 0, 0);

        return max;
    }

    private void dfs(int[][] f, int[][] d, int curr, int week, int sum) {
        if (week == K) {
            max = Math.max(max, sum);
            return;
        }

        for (int dest = 0; dest < N; dest++) {
            if (curr == dest || f[curr][dest] == 1) {
                dfs(f, d, dest, week + 1, sum + d[dest][week]);
            }
        }
    }
}

// DP: https://discuss.leetcode.com/topic/87865/java-dfs-tle-and-dp-solutions/2
// dp[i][j] stands for the max vacation days we can get in week i staying in city j.
// It's obvious that dp[i][j] = max(dp[i - 1][k] + days[j][i]) (k = 0...N - 1,
// if we can go from city k to city j).
// Also because values of week i only depends on week i - 1,
// so we can compress two dimensional dp array to one dimension.
// Time complexity O(K * N * N) as we can easily figure out from the 3 level of loops.

class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int N = flights.length;
        int K = days[0].length;

        int[] dp = new int[N]; // max days ending in city i
        Arrays.fill(dp, Integer.MIN_VALUE); // not starting from other cities than city 0, so adding a penalty here
        dp[0] = 0;

        for(int i=0; i<K; i++) {
            int[] temp = new int[N];
            Arrays.fill(temp, Integer.MIN_VALUE); // cannot reach each cities at first, penalty

            for(int j=0; j<N; j++) { // for each destination cities
                for(int k=0; k<N; k++) { // for each origin cities
                    if (flights[k][j] == 1 || k == j) { // k==j meaning one can stay at the current city
                        temp[j] = Math.max(temp[j], dp[k] + days[j][i]);
                    }
                }
            }
            dp = temp;
        }

        int max = 0;
        for(int v : dp) {
            max = Math.max(max, v);
        }

        return max;
    }
}
