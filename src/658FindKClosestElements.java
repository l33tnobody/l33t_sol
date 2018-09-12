class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new LinkedList<>();
        // get insertion point at index: arr[index] >= x
        // and if it exists, array[index - 1] will be <= x
        int index = bsearch(arr, x);
        int i = index - 1, j = index;
        while(k > 0) {
            if(i < 0) res.add(arr[j++]);
            else if (j >= arr.length) res.add(0, arr[i--]);
            else {
                // both i, j exists pick closer one, 
                // note, x >= arr[i] and true for smaller i, and arr[j] >= x and true for bigger j
                // so no Math.abs is needed
                if(x - arr[i] <= arr[j] - x) res.add(0, arr[i--]);
                else res.add(arr[j++]);
            }
            k--;
        }
        return res;    
    }
    
    // similar to Collections.binarySearch(arr, x), except from always returning insertion point in non-negative index
    // for reference: https://github.com/openjdk-mirror/jdk7u-jdk/blob/master/src/share/classes/java/util/Collections.java
    private int bsearch(int[] arr, int x) {
        int l = 0, h = arr.length - 1;
        while(l <= h) {
            int mid = l + (h - l) / 2;
            if(arr[mid] == x) return mid;
            if(arr[mid] > x) h = mid - 1;
            else l = mid + 1;
        }
        return l; // no exact match, return insertion point, range from 0 to arr.length
    }
}

// see k numbers as one number, and use binary search to find where it starts:
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
