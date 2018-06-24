// not sure why only this bsearch works
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int index = bsearch(arr, x);
        int i = index, j = index;
        while(k - 1 > 0) {
            if(i == 0) {
                j++;
            } else if(j == arr.length - 1) {
                i--;
            } else if( Math.abs(arr[i-1] - x) <= Math.abs(arr[j+1] - x)) {
                i--;
            } else {
                j++;
            }
            k--;
        }

        for(int it = i; it <= j; it++) res.add(arr[it]);
        return res;
    }

    private int bsearch(int[] arr, int x) {
        int l = 0, h = arr.length - 1;
        while(l < h) {
            int mid = l + (h - l) / 2;
            if(arr[mid] == x) return mid;
            if(arr[mid] > x) h = mid - 1;
            else l = mid + 1;
        }

        return l; // have to return l in such case
    }
}


// binary-search for where the resulting elements start in the array.
// It's the first index i so that arr[i] is better than arr[i+k]
// (with "better" meaning closer to or equally close to x).
// Then I just return the k elements starting there.
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int lo = 0, hi = arr.length - k;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (Math.abs(x - arr[mid]) > Math.abs(arr[mid+k] - x)) // abs is not needed but hard to realize
                lo = mid + 1;
            else
                hi = mid;
        }

        List<Integer> res = new ArrayList<>();
        for(int i=lo; i<lo + k; i++) res.add(arr[i]);
        return res;
    }
}
