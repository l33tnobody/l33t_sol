class Solution {
    public int monotoneIncreasingDigits(int N) {
        char[] digits = (N + "").toCharArray();
        int pos = digits.length;

        for(int i = digits.length - 1; i > 0; i--) {
            if(digits[i-1] > digits[i]) {
                pos = i; // will set to 9 from here to the end
                digits[i-1]--; // on char
            }
        }

        for(int j = pos; j<digits.length; j++) {
            digits[j] = '9';
        }

        return Integer.parseInt(new String(digits));
    }
}
