public class Solution {
    public int countPrimes(int n) {
        boolean[] b = new boolean[n]; // false is prime number
        int count = 0;

        for(int i=2; i<n; i++) {
            if(b[i] == false) {
                count++;
                for(int j=2*i; j<n; j+=i) {
                    b[j] = true;
                }
            }
        }

        return count;
    }
}
