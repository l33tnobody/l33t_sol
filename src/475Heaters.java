// O(nlogn) + O(mlogn) given m houses and n heaters
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters); // find a house among two closest heaters, has to sort heaters
        int res = Integer.MIN_VALUE; // or 0

        for(int h : houses) {
            // int index = Arrays.binarySearch(heaters, h); // or use the given binarysearch function
            // if(index < 0) index = -index - 1; // the greater key
            int index = ceiling(heaters, h);
            int dist1 = index - 1 >= 0 ? h - heaters[index - 1] : Integer.MAX_VALUE;
            int dist2 = index < heaters.length ? heaters[index] - h : Integer.MAX_VALUE;
            res = Math.max(res, Math.min(dist1, dist2)); // min can cover but try to find global max
        }

        return res;
    }

    private int ceiling(int[] a, int t) { // the ceiling binarysearch
        int l = 0, h = a.length - 1;
        while(l <= h) {
            int mid = l + (h - l) / 2;
            if(a[mid] == t) return mid;
            if(a[mid] < t) l = mid + 1;
            else h = mid - 1;
        }
        return l;
    }

    /* a little bit better ceiling binary search:
    private int ceiling(int[] a, int t) { // the ceiling binarysearch
        int l = 0, h = a.length;
        while(l < h) {
            int mid = l + (h - l) / 2;
            if(a[mid] < t) l = mid + 1;
            else h = mid;
        }
        return h;
    }
    */
}

// using treemap: same runtime
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        TreeSet<Integer> treeset = new TreeSet<>();
        for (int heater : heaters) treeset.add(heater);

        int res = 0;

        for (int house : houses) {
            Integer upper = treeset.ceiling(house);
            Integer lower = treeset.floor(house);
            int d1 = upper == null ? Integer.MAX_VALUE : upper - house;
            int d2 = lower == null ? Integer.MAX_VALUE : house - lower;
            res = Math.max(res, Math.min(d1, d2));
        }

        return res;
    }
}



// or continuous two pointers, just for fun: mlogm + nlogn + m + n so O(max(mlogm, nlogn))
public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int i = 0, j = 0, res = 0;
        while (i < houses.length) {
            while (j < heaters.length - 1
                && Math.abs(heaters[j + 1] - houses[i]) <= Math.abs(heaters[j] - houses[i])) {
                j++;
            }
            res = Math.max(res, Math.abs(heaters[j] - houses[i]));
            i++;
        }

        return res;
    }
}
