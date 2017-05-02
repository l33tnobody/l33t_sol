public class Solution {
    public String countAndSay(int n) {
        if (n <= 0) return "";

        StringBuffer res = new StringBuffer();
        res.append("1");

        for(int i=2; i<=n; i++) {
            StringBuffer newres = new StringBuffer();
            int count = 1;

            for(int j=0; j<res.length(); j++) {
                if (j+1 < res.length() && res.charAt(j) == res.charAt(j+1)) {
                    count++;
                } else {
                    newres.append(count).append(res.charAt(j));
                    count = 1;
                }
            }
            res = newres;
        }

        return res.toString();
    }
}

public class Solution {
    public String countAndSay(int n) {
        if(n<=0) return "";
        StringBuffer res=new StringBuffer("1");
        for(int i=2;i<=n;i++){
            StringBuffer buf=new StringBuffer();
            int count=1;
            for(int j=1;j<res.length();j++){
                if(res.charAt(j)==res.charAt(j-1))
                    count++;
                else{
                    buf.append(count);
                    buf.append(res.charAt(j-1));
                    count=1;
                }
            }
            buf.append(count);
            buf.append(res.charAt(res.length()-1));
            res=buf;
        }
        return res.toString();
    }
}
