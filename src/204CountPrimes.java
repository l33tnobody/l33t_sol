public class Solution {
    public int countPrimes(int n) {
        boolean[] b = new boolean[n]; // false is prime number
        int count = 0;

        for(int i=2; i<n; i++) {
            if(b[i] == false) {
                count++;
                for(int j=2*i; j<n; j+=i) {
                // or for(int j=2; j*i<n; j++) {
                    b[j] = true;
                // or b[j*i] = true;
                }
            }
        }

        return count;
    }
}
