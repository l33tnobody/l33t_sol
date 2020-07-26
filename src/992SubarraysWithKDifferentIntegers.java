class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        int n = A.length;
        int[] m = new int[n+1];
        int cnt = 0;
        int prefix = 0;
        int res = 0;

        for(int i=0, j=0; j < n; j++) {
            if(m[A[j]] == 0) cnt++;
            m[A[j]]++;

            if(cnt > K){
                --m[A[i]]; i++; cnt--; prefix = 0;
            }

            if(cnt == K) {
                while(m[A[i]] > 1) {
                    prefix++; --m[A[i]]; i++;
                }

                res += 1 + prefix;
            }

        }

        return res;
    }
}