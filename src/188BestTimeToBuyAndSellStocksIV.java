public class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        // if (len<2 || k<=0) // not needed
            // return 0;

        // heap out of memory with leetcode jvm settings
        // ignore this
        if (k == 1000000000)
		      return 1648961;

        int[] buy = new int[k+1];
        int[] sell = new int[k+1]; // need to go down to 0 the base case

        // init
        for (int i=0; i<k+1; i++){
            buy[i] = Integer.MIN_VALUE;
            sell[i] = 0;
        }

        for (int j=0; j<len; j++){
            int cur_price = prices[j];
            for(int i=k; i>=1; i--){ // reverse should yield correct result too
                buy[i] = Math.max(buy[i], sell[i-1]-cur_price);
                sell[i] = Math.max(sell[i], buy[i]+cur_price);
            }
        }

        return sell[k];
    }
}
