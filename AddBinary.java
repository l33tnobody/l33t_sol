public class Solution {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        StringBuilder res=new StringBuilder();
        int carry=0;
        int sum=0;
        int i=a.length()-1;
        int j=b.length()-1;
        while(i>=0||j>=0||carry!=0){
            int adigit=(i>=0? a.charAt(i)-'0' : 0);
            int bdigit=(j>=0? b.charAt(j)-'0' : 0);
            sum=adigit+bdigit+carry;
            carry=sum/2;
            sum%=2;
            res.insert(0, sum);
            i--;j--;
        }
        return res.toString();
    }
}
