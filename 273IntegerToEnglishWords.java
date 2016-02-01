public class Solution {
    private static final String[] lt20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] thousands = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";

        int i=0;
        String res="";

        while (num>0) {
            if (num%1000 != 0) {
                res = helper(num%1000) + thousands[i] + " " + res;
            }
            num/=1000;
            i++;
        }

        return res.trim();
    }

    private String helper(int num) {
        if (num==0)
            return "";
        if (num<20)
            return lt20[num] + " "; //0 will output nothing here
        if (num<100)
            return tens[num/10] + " " + helper(num%10);
        // <1000
        return lt20[num/100] + " Hundred " + helper(num%100);
    }
}


// or:

public class Solution {
    private static final String[] lt20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";

        return helper(num);
    }

    private String helper(int num) {
        String result = "";

        if (num<20)
            result = lt20[num];
        else if (num<100)
            result = tens[num/10] + " " + helper(num%10);
        else if (num<1000)
            result = lt20[num/100] + " Hundred " + helper(num%100);
        else if (num<1000000)
            result = helper(num/1000) + " Thousand " + helper(num%1000);
        else if (num<1000000000)
            result = helper(num/1000000) + " Million " + helper(num%1000000);
        else //billion
            result = helper(num/1000000000) + " Billion " + helper(num%1000000000);

        return result.trim();
    }
}
