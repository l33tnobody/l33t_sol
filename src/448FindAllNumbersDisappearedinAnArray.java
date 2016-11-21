public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        int n = nums.length;

        for(int i=0; i<n; i++){
            if(nums[i]!=i+1){
                int j=nums[i]-1;
                if(nums[j]!=nums[i]){
                    swap(nums, i, j);
                    i--;
                }
            }
        }

        for(int i=0; i<n; i++){
            if(nums[i]!=i+1){
                res.add(i+1);
            }
        }

        return res;
    }

    private void swap(int[] nums, int i, int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}
