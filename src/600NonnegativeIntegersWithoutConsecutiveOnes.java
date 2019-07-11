// too hard to guess, see less
// https://discuss.leetcode.com/topic/90571/java-solution-dp

public class Solution {
    public int findIntegers(int num) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(num)).reverse();
        int n = sb.length();

        int a[] = new int[n]; // ends with 0
        int b[] = new int[n]; // ends with 1
        a[0] = b[0] = 1;
        for (int i = 1; i < n; i++) {
            a[i] = a[i - 1] + b[i - 1];
            b[i] = a[i - 1];
        }

        int result = a[n - 1] + b[n - 1];
        // remove greater valid ones: over count
        for (int i = n - 2; i >= 0; i--) {
            if (sb.charAt(i) == '1' && sb.charAt(i + 1) == '1') break; // greater ones must have consecutive 1s no more over count
            // '0', '1' greater ones '1', '1' no over count
            // '1', '0' greater ones '1', '1' no over count
            if (sb.charAt(i) == '0' && sb.charAt(i + 1) == '0') result -= b[i]; // remove the senario of '1', '0', as for '0', '1', it depends on i + 2 is 0 or not, if yes, already extracted overcount
        }

        return result;
    }
}
