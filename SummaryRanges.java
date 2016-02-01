public class Solution {
    public List<String> summaryRanges(int[] nums) {
        int left=0;
        int right=1;
        List<String> res = new LinkedList<String>();

        if(nums==null || nums.length==0)
            return res;

        for(;right<nums.length; right++){
            if(nums[right]==nums[right-1]+1)
                continue;
            String entry = nums[right-1]==nums[left] ?
                Integer.toString(nums[left]) :
                Integer.toString(nums[left]) + "->" + Integer.toString(nums[right-1]);
            res.add(entry);
            left=right;
        }

        String finalEntry = left==nums.length-1 ?
            Integer.toString(nums[left]) :
            Integer.toString(nums[left])+"->"+Integer.toString(nums[nums.length-1]);
        res.add(finalEntry);

        return res;
    }
}


// a better implementation
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        int length = nums.length;
        List<String> result = new ArrayList<String>(length);

        for (int i = 0; i < length; i++) {
            int num = nums[i];

            while (i < length - 1 && nums[i] + 1 == nums[i + 1]) {
                i++;
            }

            if (num != nums[i]) {
                result.add(num + "->" + nums[i]);
            } else {
                result.add(num + "");
            }
        }

        return result;
    }
}
