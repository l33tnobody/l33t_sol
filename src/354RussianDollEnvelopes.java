// dp: n^2, easy to remember
// sort on one dimention and then compare both dimentions
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>(){ //java 8: Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);
            @Override
            public int compare(int[] e1, int[] e2) {
                return e1[0] - e2[0];
            }
        });

        int n = envelopes.length;
        int[] dp = new int[n];

        int ret = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] &&
                    envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }

            ret = Math.max(ret, dp[i]);
        }

        return ret;
    }
}

// binary search: nlogn
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2){
                if(arr1[0] == arr2[0])
                    return arr2[1] - arr1[1]; // avoid 3,3  3,4 count as a valid sequence when width is the same, sort height descendingly
                else
                    return arr1[0] - arr2[0];
           }
        });

        int[] tails = new int[envelopes.length];
        int size = 0;
        for (int[] e : envelopes) {
            int i = 0, j = size;
            while (i != j) {
                int m = i + (j - i) / 2;
                if (tails[m] < e[1])
                    i = m + 1;
                else
                    j = m;
            }
            tails[j] = e[1];
            if (j == size) ++size;
        }
        return size;
    }
}
