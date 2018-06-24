class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--) {
            if(carry == 0) break;

            int d = digits[i];
            d += carry;
            digits[i] = d % 10;
            carry = d / 10;
        }

        if(carry == 0) return digits;

        int[] res = new int[digits.length + 1];
        res[0] = carry; // or just put 1
        for(int i = 1; i - 1 < digits.length; i++) {
            res[i] = digits[i - 1];
        }
        return res;
    }
}
