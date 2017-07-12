/// essentially:
public class Solution {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        int sell1 = 0, sell2 = 0;
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

// tracking buy and sell status:
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int states[2][4] = {INT_MIN, 0, INT_MIN, 0}; // 0: one buy no sell, 1: one buy one sell, 2: two buys one sell, 3, two buys two sells
        int len = prices.size(), i, cur = 0, next =1;
        for(i=0; i<len; ++i)
        {
            states[next][0] = max(states[cur][0], -prices[i]);
            states[next][1] = max(states[cur][1], states[cur][0]+prices[i]);
            states[next][2] = max(states[cur][2], states[cur][1]-prices[i]);
            states[next][3] = max(states[cur][3], states[cur][2]+prices[i]);
            swap(next, cur);
        }
        return max(states[cur][1], states[cur][3]);
        // actually states[cur][3] which represents two buys and sells will always be >= states[cur][1]
        // this is because all one buy and one sell can always be broken into two transactions
        // two transactions max are a super set
        // so equivalent to return states[cur][3];
    }
};



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
