class Solution {
    public String minWindow(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        int[] needtofind = new int[128];
        for (int i = 0; i < tlen; i++)
            needtofind[geti(t.charAt(i))]++;

        int minWindowLen = Integer.MAX_VALUE;
        int minstart = 0, minend = -1;
        int count = 0;

        for (int start = 0, end = 0; end < slen; end++) {
            int curi = geti(s.charAt(end));
            if (--needtofind[curi] >= 0)
                count++;

            if (count == t.length()) {
                while (needtofind[geti(s.charAt(start))] < 0) {
                    needtofind[geti(s.charAt(start))]++;
                    start++;
                }

                if (end - start + 1 < minWindowLen) {
                    minWindowLen = end - start + 1;
                    minstart = start;
                    minend = end;
                }
            }
        }

        return s.substring(minstart, minend + 1);
    }

    private static int geti(char c) {
        return c - 'A'; // 'A' is smaller than 'a'
    }
}

public class Solution {
    public String minWindow(String s, String t) {

        int slen=s.length();
        int tlen=t.length();
        int[] needtofind=new int[128];
        for (int i=0;i<tlen;i++)
            needtofind[geti(t.charAt(i))]++;
        int[] found=new int[128];

        int minWindowLen=Integer.MAX_VALUE;
        int minstart=0, minend=-1;
        int count=0;

        for(int start=0,end=0; end<slen; end++) {
            int curi = geti(s.charAt(end));
            if(needtofind[curi]==0)
                continue;

            found[curi]++;
            if(found[curi]<=needtofind[curi])
                count++;

            if(count==tlen) { //a match
                //shift s as far as possible
                while( needtofind[geti(s.charAt(start))] == 0 ||
                    found[geti(s.charAt(start))] > needtofind[geti(s.charAt(start))] ) {
                        if (found[geti(s.charAt(start))] > needtofind[geti(s.charAt(start))])
                            found[geti(s.charAt(start))]--;
                        start++;
                }
                if(end - start + 1 < minWindowLen){
                    minWindowLen = end - start + 1;
                    minstart=start;
                    minend=end;
                }
            }
        }

        return s.substring(minstart,minend+1); // "" if no matching
    }

    private static int geti(char c){
        return c-'A';   //'A' is smaller than 'a'
    }
}
