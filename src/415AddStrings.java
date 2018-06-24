class Solution {
    public String addStrings(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        StringBuilder res = new StringBuilder();
        int carry = 0;

        for(int i = n1 - 1, j = n2 - 1; i >= 0 || j >= 0 || carry != 0 ; i--, j--) {
            int v1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int v2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int val = v1 + v2 + carry;
            carry = val >= 10 ? 1 : 0;
            val %= 10;
            res.insert(0, val);
        }

        return res.toString();
    }
}
