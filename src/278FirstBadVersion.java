/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {

        int left=1, right=n;
        int mid;

        while(left<right){
            mid=left + (right-left)/2; //prevent overflow of big numbers addition
            if (isBadVersion(mid))
                right=mid;
            else
                left=mid+1;
        }
        return left;
    }
}
