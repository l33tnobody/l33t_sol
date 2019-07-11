public class Solution {
    public int numDecodings(String s) {
        if(s.length()==0)   return 0;   //stupid test case of ""

        long pre0=1, pre1=1;
        for(int i=0; i<s.length(); i++){
            long temp=0;
            temp += valid(s, i, 1, pre1);
            temp += valid(s, i, 2, pre0);
            // temp = mod(temp); // optional for the test cases
            pre0=pre1;
            pre1=temp;
        }
        return (int)mod(pre1);
    }

    private long valid(String s, int i, int len, long pre) {
        if (len == 1) {
            if (s.charAt(i) == '*') return mod(9*pre);

            int d = s.charAt(i) - '0';
            if(d >=1 && d<= 9)  return mod(pre);

        } else if(len == 2 && i - 1 >= 0) {
            if (s.charAt(i-1) == '*') { // all cases included when digit prior is *
                if (s.charAt(i) == '*') return mod(15*pre); // 11 - 19, 21 - 26

                int d = s.charAt(i) - '0';
                if (d>=0 && d<=6) return mod(2*pre); // 1x or 2x
                if (d>6 && d<=9) return mod(pre); // 1x
            }

            // prior digit is not *
            int dpre = s.charAt(i-1) - '0';
            if (dpre == 1) {
                if (s.charAt(i) == '*') return mod(9*pre);

                return mod(pre); // 10 - 19 are all good
            } else if (dpre == 2) {
                if (s.charAt(i) == '*') return mod(6*pre); // 21 - 26

                int d = s.charAt(i) - '0';
                if (d<=6) return mod(pre);
            }
            // OR:
            // // prior digit is not *
            // if (s.charAt(i) == '*') {
            //     int dpre = s.charAt(i-1) - '0';
            //     if (dpre == 1) return mod(9*pre); // 11 - 19
            //     if (dpre == 2) return mod(6*pre); // 21 - 26
            // } else {
            //     int num = (s.charAt(i-1) - '0')*10 + (s.charAt(i) - '0');
            //     if(num >= 10 && num <= 26) return mod(pre);
            // }
        }

        return 0;
    }

    private long mod(long num) {
        return num % ((long)1000000000 + 7);
    }
}
