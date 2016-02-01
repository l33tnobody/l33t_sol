public class Solution {
    public String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len1=num1.length();
        int len2=num2.length();
        
        int[] res=new int[len1+len2];
        int n=len1+len2;
        
        for(int i=len1-1;i>=0;i--){
            for(int j=len2-1;j>=0;j--){
                res[i+j+1]+=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
            }
        }
        
        int carry=0;
        for(int i=n-1;i>=0;i--){
            res[i]+=carry;
            carry=res[i]/10;
            res[i]=res[i]%10;
        }
        
        int i=0;
        while(i<n-1&&res[i]==0) i++;
        
        StringBuilder sb=new StringBuilder();
        while(i<n)  sb.append(res[i++]);
        
        return sb.toString();
    }
}
