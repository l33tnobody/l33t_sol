class Solution {
    
    private int[] mynums;
    private Random rand;

    public Solution(int[] nums) {
        mynums = nums;
        rand = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return mynums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] res = Arrays.copyOf(mynums, mynums.length);
        
        for(int i=res.length - 1; i>=0; i--) {
            int j = rand.nextInt(i + 1); // or int j = (int)Math.floor(Math.random() * (i+1));
            swap(res, i, j);
        }
        return res;
    }
    
    private void swap(int[] res, int i, int j) {
        if(i == j) return;
        
        int t = res[i];
        res[i] = res[j];
        res[j] = t;
    }
}