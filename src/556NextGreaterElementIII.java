// similar to 31 Next Permutation; pay attention to int too large that cannot fit into 32bit
// return -1

class Solution {
    public int nextGreaterElement(int n) {
        char[] a = ("" + n).toCharArray();
        int i = a.length - 1;
        while(i > 0 && a[i-1] >= a[i] ) i--;

        if(i == 0) return -1;

        i--;
        int j = a.length - 1;
        while(a[j] <= a[i]) j--; // find the first greater num
        swap(a, i, j);
        reverse(a, i+1, a.length - 1);
        try {
            return Integer.parseInt(new String(a));
        } catch(Exception e) {
            return -1;
        }
    }

    public void swap(char[] a, int i, int j) {
        char c = a[i];
        a[i] = a[j];
        a[j] = c;
    }

    public void reverse(char[] a, int s, int e) {
        while(s < e) {
            swap(a, s, e);
            s++;
            e--;
        }
    }
}
