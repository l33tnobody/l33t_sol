// just for fun:
class Solution {
    public int findNthDigit(int n) {
        int len = 1;
		long count = 9;
		int start = 1;
        
        while (n > len * count) {
            n -= len * count;
            len++;
            count *= 10; // 9 1-digit (1-9) 90 2-digits(10-99) 900 3-digits(100-999)...
            start *= 10;
        }
        
        start += (n - 1) / len;
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }
}