class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        List<String> list = new ArrayList<String>(); // contains all words in a single line after the first word
        
        StringBuilder sb = new StringBuilder();
        int cur = 0; // current word
        int len = 0; // total length without whitespace adjustment
        
        while (cur < words.length) {    //new line
            sb.setLength(0);
            sb.append(words[cur]);
            list.clear();
            len = words[cur].length();
            cur++;
            
            while (cur < words.length && len + 1 + words[cur].length() <= maxWidth) { // greedily fit as many words in the current line as possible
                list.add(" " + words[cur]);
                len += 1 + words[cur].length();
                cur++;
            }
            
            if (cur < words.length && list.size() > 0) { //not last line and not single word
                int spaces = maxWidth - len;
                int avg = spaces / list.size();
                int rem = spaces % list.size();
                for (int i=0; i<list.size(); i++) {
                    appendSpaces(sb, i < rem ? avg+1 : avg);
                    sb.append(list.get(i));
                }
            } else { // last line or only single word in a line, put extra spaces in the end
                for (int i=0; i<list.size(); i++) sb.append(list.get(i));
                appendSpaces(sb, maxWidth - len);
            }
            
            res.add(sb.toString());  
        }
        
        return res;
    }
    
    private void appendSpaces(StringBuilder sb, int n) {
        for (int i=0; i<n; i++) sb.append(' ');
    }
}