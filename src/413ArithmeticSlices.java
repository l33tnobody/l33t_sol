// O(n) time
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int sum = 0, cur = 0;
        for(int i=2; i<A.length; i++) {
            if(A[i] - A[i-1] == A[i-1] - A[i-2]) {
                cur = cur + 1; // number of slices ends at i
                sum += cur;
            } else {
                cur = 0;
            }
        }
        return sum;
    }
}

// or write with a 1d dp[]
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        int[] dp = new int[n]; // number of slices ends at i
        int sum = 0;

        for(int i=2; i<n; i++) {
            if(A[i] - A[i-1] == A[i-1] - A[i-2]) {
                dp[i] = dp[i-1] + 1;
                sum += dp[i];
            }
        }

        return sum;
    }
}

// a not as good, n^2 approach:
public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int count = 0;
        for (int s = 0; s < A.length - 2; s++) {
            int d = A[s + 1] - A[s];
            for (int e = s + 2; e < A.length; e++) {
                if (A[e] - A[e - 1] == d)
                    count++;
                else
                    break;
            }
        }
        return count;
    }
}