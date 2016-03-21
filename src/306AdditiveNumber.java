// iterative
public class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for(int i=1; i<=n/2; i++){
            if(num.charAt(0)=='0' && i>1) return false;
            for(int j=1; Math.max(i,j)<=n-i-j; j++){
                if(num.charAt(i)=='0' && j>1) break; // try next i
                if (isValid(i, j, num)) return true;
            }
        }
        return false;
    }

    private boolean isValid(int i, int j, String num) {
        Long x1 = Long.parseLong(num.substring(0,i));
        Long x2 = Long.parseLong(num.substring(i,i+j));
        int start=i+j;
        while(start!=num.length()){
            Long sumv=x1+x2;
            String sum=sumv.toString();
            if(!num.startsWith(sum, start)) return false;
            x1=x2;
            x2=sumv;
            start+=sum.length();
        }
        return true;
    }
}

// recursive
import java.math.BigInteger;

public class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for(int i=1; i<=n/2; i++){
            if(num.charAt(0)=='0' && i>1) return false;
            BigInteger x1 = new BigInteger(num.substring(0, i));
            for (int j=1; Math.max(i,j) <= n-i-j; j++){
                if (num.charAt(i)=='0' && j>1) break;
                BigInteger x2 = new BigInteger(num.substring(i,i+j));
                if (isValid(x1, x2, i+j, num)) return true;
            }
        }
        return false;
    }

    private boolean isValid(BigInteger x1, BigInteger x2, int start, String num){
        if (start==num.length()) return true;
        //rotate next two integers
        x2=x2.add(x1);
        x1=x2.subtract(x1);
        String sum=x2.toString();
        return num.startsWith(sum, start) && isValid(x1, x2, start+sum.length(), num);
    }
}
