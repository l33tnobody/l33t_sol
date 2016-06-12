// more exciting
public class Solution {
    public String reverseWords(String s) {
        int l=0, r=0;
        StringBuilder res = new StringBuilder();
        for(; r<s.length(); r++){
            if (s.charAt(r) == ' '){
                if (r>l) {
                    res.insert(0, ' ');
                    res.insert(0, s.substring(l, r));
                }
                l=r+1;
            }
        }
        if (r>l){
            res.insert(0, ' ');
            res.insert(0, s.substring(l, r));
        }
        if (res.length() != 0)
            res.deleteCharAt(res.length()-1);
        return res.toString();
    }
}

// not so exciting:
public class Solution {
    public String reverseWords(String s) {
        String[] parts = s.trim().split("\\s+");
        String out = "";
        for (int i = parts.length - 1; i > 0; i--) {
            out += parts[i] + " ";
        }
        return out + parts[0];
    }
}
