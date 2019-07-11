// binary search: n^2logmaxdiff
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0], high = matrix[n-1][n-1];

        while(low < high) {
            int mid = low + (high - low) / 2;
            int c = count(mid, matrix);
            if(c < k) low = mid + 1;
            else high = mid;
        }

        return high;
    }

    private int count(int val, int[][] matrix) {
        int res = 0;
        int n = matrix.length;
        for(int i = 0; i < n; i++) {
            int j = 0;
            while(j < n && matrix[i][j] <= val) j++;
            res += j;
        }
        return res;
    }
/*  or use binary search on count to make it even faster: count: O(nlogn), total: nlognlogmaxdiff
    private int count(int val, int[][] matrix) {
        int res = 0;
        int n = matrix.length;
        for(int i = 0; i < n; i++) {
            int j = higherKey(matrix[i], val);
            res += j;
        }
        return res;
    }

    // find the least key (index) which is strictly greater than val
    private int higherKey(int[] row, int val) {
        int n = row.length;
        // if(row[n-1] <= val) return n;

        int l = 0, h = n; // h = n-1;
        while(l < h) {
            int mid = l + (h - l) / 2;
            if(row[mid] <= val) l = mid + 1;
            else h = mid;
        }
        return h; // could be n
    }
*/
}

// O(n^2logn) k can be up to n^2
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix[0].length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>(n, (a, b) -> (a.val - b.val)); // or Math.min(n, k)
        for(int j = 0; j < n; j++) pq.offer(new Tuple(0, j, matrix[0][j])); // have to add the whole row/column
        for(int i = 0; i < k-1; i++) { // poll and add k-1 times
            Tuple t = pq.poll();
            if(t.x == n - 1) continue;
            pq.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
        }

        return pq.peek().val;
    }

    class Tuple {
        int x, y, val;
        public Tuple (int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}
