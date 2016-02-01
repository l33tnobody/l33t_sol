public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> res = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        int cur = 0;
        int len = 0;
        
        while (cur < words.length) {    //new line
            sb.setLength(0);
            sb.append(words[cur]);
            list.clear();
            len = words[cur].length();
            cur++;
            
            while (cur<words.length && len + 1 + words[cur].length() <= L) {
                list.add(" " + words[cur]);
                len += 1 + words[cur].length();
                cur++;
            }
            
            if (cur < words.length && list.size() > 0) { //not last line and not single word
                int spaces = L - len;
                int avg = spaces / list.size();
                int rem = spaces % list.size();
                for (int i=0; i<list.size(); i++) {
                    appendSpaces(sb, i<rem? avg+1 : avg);
                    sb.append(list.get(i));
                }
                
            } else{ // last line or only single word in a line, put extra spaces behind
                for (int i=0; i<list.size(); i++) sb.append(list.get(i));
                appendSpaces(sb, L - len);
                
            }
            
            res.add(sb.toString());  
            
        }
        
        return res;
    }
    
    private void appendSpaces(StringBuilder sb, int n) {
        for (int i=0; i<n; i++) sb.append(' ');
    }
    
}
