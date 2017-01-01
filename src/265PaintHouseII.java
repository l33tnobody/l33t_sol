public class Solution {
    public int minCostII(int[][] costs) {
        if (costs.length == 0) return 0;

        int n = costs.length;
        int k = costs[0].length;
        int min1 = -1, min2 = -1;
        int [][] total = new int[n][k]; // don't override costs as input

        for (int i=0; i<n; i++) { // for each house
            int lastmin1 = min1, lastmin2 = min2;
            min1 = -1; min2 = -1;

            for (int j=0; j<k; j++) {
                if (j != lastmin1) {
                    total[i][j] = (lastmin1 == -1 ? 0 : total[i-1][lastmin1]) + costs[i][j];
                } else {
                    total[i][j] = (lastmin2 == -1 ? 0 : total[i-1][lastmin2]) + costs[i][j];
                }

                if (min1 == -1 || total[i][j] < total[i][min1]) {
                    min2= min1;
                    min1 = j;
                } else if (min2 == -1 || total[i][j] < total[i][min2]) {
                    min2 = j;
                }
            }
        }

        return total[n-1][min1];
    }
}
