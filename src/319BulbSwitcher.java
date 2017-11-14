class Solution {
    public int bulbSwitch(int n) {
        // return (int)Math.sqrt(n); // or simply

        int count = 0;

        for(int i=1; i*i<=n; i++) {
            count++;
        }

        return count;
    }
}
