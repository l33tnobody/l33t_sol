/* just need to reverse:
For example, given IDIIDD we start with sorted sequence 1234567
Then for each k continuous D starting at index i we need to reverse [i, i+k] portion of the sorted sequence.

IDIIDD
1234567 // sorted
1324765 // answer
*/

class Solution {
    public int[] findPermutation(String s) {
        int n = s.length();
        int arr[] = new int[n + 1];
        for (int i = 0; i <= n; i++) arr[i] = i + 1; // sorted

        for (int h = 0; h < n; h++) {
            if (s.charAt(h) == 'D') {
                int l = h++;
                while (h < n && s.charAt(h) == 'D') h++;
                reverse(arr, l, h);
            }
        }
        return arr;
    }

    public void reverse(int[] arr, int l, int h) {
        while(l < h) {
            int t = arr[l];
            arr[l] = arr[h];
            arr[h] = t;
            l++; h--;
        }
    }
}
