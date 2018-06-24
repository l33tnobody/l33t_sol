public class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] res = new int[len1 + len2];
        int n = len1 + len2;

        for(int i = len1 - 1; i >= 0; i--){
            int carry = 0;
            int d1 = num1.charAt(i) - '0';
            for(int j = len2 - 1; j >= 0; j--){
                int d2 = num2.charAt(j) - '0';
                res[i+j+1] += d1 * d2 + carry;
                carry = res[i+j+1] / 10;
                res[i+j+1] = res[i+j+1] % 10;
            }
            res[i] += carry;
        }

        int i = 0;
        while(i < n - 1 && res[i]==0) i++; //first non 0 digit or last digit (could be 0)

        StringBuilder sb = new StringBuilder();
        while(i < n)
            sb.append(res[i++]);

        return sb.toString();
    }
}
