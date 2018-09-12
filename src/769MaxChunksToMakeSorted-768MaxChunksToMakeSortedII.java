// sorting O(nlogn) time, n space
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] arrcopy = arr.clone();
        Arrays.sort(arrcopy);
        int sum = 0, sum1 = 0;
        
        int count = 0;
        for(int i=0; i<arr.length; i++) {
            sum+=arr[i];
            sum1+=arrcopy[i];
            if(sum == sum1) count++;
        }
        return count;
    }
}

// O(n) time and space
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] maxOfLeft = new int[n];
        int[] minOfRight = new int[n];

        maxOfLeft[0] = arr[0];
        for (int i = 1; i < n; i++) {
            maxOfLeft[i] = Math.max(maxOfLeft[i-1], arr[i]);
        }

        minOfRight[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minOfRight[i] = Math.min(minOfRight[i + 1], arr[i]);
        }

        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            if (maxOfLeft[i] <= minOfRight[i + 1]) res++;
        }

        return res + 1;
    }
}