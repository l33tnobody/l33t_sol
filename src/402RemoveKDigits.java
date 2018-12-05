// use a stack, greedy: O(n): each digit in num gets pushed (exactly once) or popped (at most once).
class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder res = new StringBuilder(); // as a stack

        for(int i=0; i<num.length(); i++) {
            while(k > 0 && res.length() > 0 && res.charAt(res.length() - 1) > num.charAt(i)) {
                res.deleteCharAt(res.length() - 1); // pop()
                k--;
            }
            res.append(num.charAt(i));
        }

        while(k>0) {
            res.deleteCharAt(res.length()-1);
            k--;
        }
        // trim leading 0
        while(0 < res.length() && res.charAt(0) == '0') res.deleteCharAt(0);

        return (res.length() == 0 ? "0" : res.toString());
    }
}
