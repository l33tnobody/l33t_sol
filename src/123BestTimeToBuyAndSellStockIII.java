// essentially:
public class Solution {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        int sell1 = 0, sell2 = 0; // can do no transactions
        for(int i:prices){                              // Assume we only have 0 money at first
            // the order here can be reversed
            buy1 = Math.max(buy1, -i);          // The maximum if we've just buy  1st stock so far.
            sell1 = Math.max(sell1, buy1+i);     // The maximum if we've just sold 1nd stock so far.
            buy2 = Math.max(buy2, sell1-i);  // The maximum if we've just buy  2nd stock so far.
            sell2 = Math.max(sell2, buy2+i);     // The maximum if we've just sold 2nd stock so far.
        }
        return sell2; // release2 will always >= release1, reason see above
    }
}





// no, dont look at this solution, not generic enough
// two transactions devided in one of the days
public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len<2)
            return 0;

        int[] left = new int[len];
        int[] right = new int[len];

        left[0] = 0;
        int min = prices[0];
        for(int i=1; i<len; i++){
            min = Math.min(min, prices[i]);
            left[i] = Math.max(left[i-1], prices[i]-min);
        }

        right[len-1] = 0;
        int max = prices[len-1];
        for(int j=len-2; j>=0; j--){
            max = Math.max(max, prices[j]);
            right[j] = Math.max(right[j+1], max-prices[j]);
        }

        int maxProfit=0;
        for(int i=0; i<len; i++){
            maxProfit = Math.max(maxProfit, left[i]+right[i]);
        }
        return maxProfit;
    }
}
