// n^2 time, will time out
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if (Math.abs(nums[j]-nums[i])<=t && j-i<=k)
                    return true;
            }
        }
        return false;
    }
}

// nlogk time, tree set sorted
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<Integer>();

        for (int i=0; i<nums.length; i++){
            int curr = nums[i];
            if ((set.floor(curr)!=null && curr<=set.floor(curr)+t) ||
                (set.ceiling(curr)!=null && curr>=set.ceiling(curr)-t))
                return true;

            set.add(curr);

            if (i>=k)
                set.remove(nums[i-k]); // if there are dup numbers in the set, it should have returned true earlier on line 9
        }
        return false;
    }
}
