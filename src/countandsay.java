public class Solution {
    public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
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
