public class Solution {
    public int hIndex(int[] citations) {
        // binary search
        int left = 0;
        int len = citations.length;
        int right = len - 1;
        int mid;
        while(left<=right) {
            mid = (left + right) >> 1; // /2
            int h = len - mid;
            if (citations[mid] == h)
                return h;
            else if (citations[mid] > h)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return len - left; // left is the last valid one and closet index.
    }
}
