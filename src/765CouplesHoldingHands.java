// a greedy solution based on swapping the next ppl:
class Solution {
    public int minSwapsCouples(int[] row) {
        int res = 0;
        int n = row.length;
        int[] pos = new int[n]; // the reverse mapping from ppl to index

        for(int i=0; i<n; i++) {
            pos[row[i]] = i;
        }

        for(int i=0; i<n; i+=2) {
            int p = ( row[i] % 2 == 0 ) ? row[i] + 1 : row[i] - 1;

            if(row[i+1] != p) {
                int pi = pos[p];
                int orig_p = row[i+1];
                swap(row, i+1, pi);
                swap(pos, orig_p, p);
                res++;
            }
        }

        return res;
    }

    private void swap(int[] arr, int i, int j) { // swap values of two indexes
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}


// appendix: O(n) swap sort
public int miniSwapsArray(int[] row) {
    int res = 0, N = row.length;

    for (int i = 0; i < N; i++) {
        for (int j = row[i]; i != j; j = row[i]) {
            swap(row, i, j);
            res++;
        }
    }

    return res;
}

private void swap(int[] arr, int i, int j) {
    int t = arr[i];
    arr[i] = arr[j];
    arr[j] = t;
}
