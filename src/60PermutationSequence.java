public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n+1]; // table to look up factorial number

        factorial[0] = 1;
        for(int i=1; i<=n; i++) {
            factorial[i] = factorial[i-1] * i;
            numbers.add(i); // make it {1, 2, 3 ... n}
        }

        k--; // make it 0 index based

        StringBuilder res = new StringBuilder();
        for(int i=n; i>=1; i--) {
            int index = k / factorial[i-1];
            res.append(numbers.get(index));
            numbers.remove(index);
            k = k % factorial[i-1];
        }

        return res.toString();
    }
}
