public class Solution {
    // https://discuss.leetcode.com/topic/8398/dp-solution-in-6-lines-with-explanation-f-i-n-g-i-1-g-n-i
    // G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0)
    public int numTrees(int n) {
        int [] G = new int[n+1]; // begin with 0
        G[0] = G[1] = 1;

        for(int i=2; i<=n; ++i) {
        	for(int j=1; j<=i; ++j) {
        		G[i] += G[j-1] * G[i-j];
        	}
        }

        return G[n];
    }
}
