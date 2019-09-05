public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] idx = new int[primes.length];

        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            //find next
            ugly[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++)
                ugly[i] = Math.min(ugly[i], primes[j] * ugly[idx[j]]);

            for (int j = 0; j < primes.length; j++) {
                if (primes[j] * ugly[idx[j]] == ugly[i]) idx[j]++;
            }
        }

        return ugly[n - 1];
    }
}



// with optimization, remember next value for each prime i.e. cache the multiplication
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] idx = new int[primes.length];
        int[] val = new int[primes.length];
        Arrays.fill(val, 1);

        int next = 1;
        for (int i = 0; i < n; i++) {
            ugly[i] = next;

            next = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {

                if (val[j] == ugly[i]) {
                    val[j] = ugly[idx[j]++] * primes[j];
                }

                next = Math.min(next, val[j]);
            }
        }

        return ugly[n - 1];
    }
}
