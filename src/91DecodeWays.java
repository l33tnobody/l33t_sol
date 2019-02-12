public class Solution {
    public int numDecodings(String s) {
        if(s.length()==0)   return 0;   //stupid test case of ""

        int pre0=1, pre1=1; // or can use dp[n+1] where dp[0] = 1
        for(int i=0; i<s.length(); i++){
            int temp=0;
            if(isValid(s,i,1))  temp+=pre1;
            if(isValid(s,i,2))  temp+=pre0;
            pre0=pre1;
            pre1=temp;
        }
        return pre1;
    }

    private boolean isValid(String s, int i, int len){
        if(len == 1) {
            int d = s.charAt(i) - '0';
            if(d >=1 && d<= 9)  return true;
        } else if(len == 2 && i - 1 >= 0) {
            int num = (s.charAt(i-1)-'0')*10 + (s.charAt(i)-'0');
            if(num >= 10 && num <= 26) return true;
        }

        return false;
    }
}

// equivalent:
// dp[i] only depends on dp[i-1] and dp[i-2]
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1; // "" will have 1 way to decode

        for(int i=1; i<n+1; i++) {
            int d = s.charAt(i-1) - '0';
            if(d > 0 && d < 10) dp[i] += dp[i-1];

            if(i>1) {
                int d0 = s.charAt(i-2) - '0';
                int num = d0 * 10 + d;
                if(num >= 10 && num <= 26) dp[i] += dp[i-2];
            }
        }

        return dp[n];
    }
}