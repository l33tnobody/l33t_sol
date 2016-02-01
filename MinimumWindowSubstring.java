public class Solution {
    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int slen=S.length();
        int tlen=T.length();
        int[] needtofind=new int[256];
        for (int i=0;i<tlen;i++)
            needtofind[geti(T.charAt(i))]++;
        int[] found=new int[256];
        
        int minWindowLen=Integer.MAX_VALUE;
        int minstart=0, minend=-1;
        int count=0;
        
        for(int s=0,e=0;e<slen;e++){
            int curi=geti(S.charAt(e));
            if(needtofind[curi]==0)
                continue;
            found[curi]++;
            if(found[curi]<=needtofind[curi])
                count++;
                
            if(count==tlen){ //a match
                //shift s as far as possible
                while(needtofind[geti(S.charAt(s))]==0 || 
                    found[geti(S.charAt(s))]>needtofind[geti(S.charAt(s))]){
                        if (found[geti(S.charAt(s))]>needtofind[geti(S.charAt(s))])
                            found[geti(S.charAt(s))]--;
                        s++;
                    }
                if(e-s+1<minWindowLen){
                    minWindowLen=e-s+1;
                    minstart=s;
                    minend=e;
                }
            }
        }
        
        return S.substring(minstart,minend+1);
    }
    
    private static int geti(char c){
        return c-'A';   //'A' is smaller than 'a'
    }
}
