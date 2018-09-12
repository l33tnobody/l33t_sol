class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();

        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++) {
            if( i!=0 && nums[i] == nums[i-1]) continue; //avoid duplicates
            int j = i + 1;
            int k = nums.length - 1;

            while(j < k) {
                if(nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                    continue;
                } else if( nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                    continue;
                }
                //found a match
                List<Integer> l = new ArrayList<>();
                l.add(nums[i]);
                l.add(nums[j]);
                l.add(nums[k]);
                res.add(l);
                do{ j++; } while ( j < k && nums[j] == nums[j-1] );
                do{ k--; } while ( j < k && nums[k] == nums[k+1] );
            }
        }

        return res;
    }
}