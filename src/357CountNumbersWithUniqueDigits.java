// https://discuss.leetcode.com/topic/47983/java-dp-o-1-solution/2
//
// Following the hint. Let f(n) = count of number with unique digits of length n.
//
// f(1) = 10. (0, 1, 2, 3, ...., 9)
//
// f(2) = 9 * 9. Because for each number i from 1, ..., 9, we can pick j to form a 2-digit number ij and there are 9 numbers that are different from i for j to choose from.
//
// f(3) = f(2) * 8 = 9 * 9 * 8. Because for each number with unique digits of length 2, say ij, we can pick k to form a 3 digit number ijk and there are 8 numbers that are different from i and j for k to choose from.
//
// Similarly f(4) = f(3) * 7 = 9 * 9 * 8 * 7....
//
// ...
//
// f(10) = 9 * 9 * 8 * 7 * 6 * ... * 1
//
// f(11) = 0 = f(12) = f(13)....
//
// any number with length > 10 couldn't be unique digits number.
//
// The problem is asking for numbers from 0 to 10^n. Hence return f(1) + f(2) + .. + f(n)

class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;

        //n = 1
        int res = 10;
        // starting from n=2
        int d0 = 9; // first digits 1-9 9 choices
        int available_digits = 9;

        for(int i=2; i<=n && available_digits>0; i++, available_digits--) {
            d0 *= available_digits;
            res += d0;
        }

        return res;
    }
}

public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)     return 1;

        // start from n==1
        int res = 10;
        // for n==2
        int uniqueDigits = 9;
        int availableNumber = 9;
        while (n > 1 && availableNumber > 0) {
            uniqueDigits = uniqueDigits * availableNumber;
            res += uniqueDigits;
            availableNumber--;
            n--;
        }
        return res;
    }
}
