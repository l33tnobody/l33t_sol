class Solution {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean mode = false; // mode under /* comment, begin to ignoring
        for (String s : source) {
            for (int i = 0; i < s.length(); i++) {
                if (mode) {
                    if (s.charAt(i) == '*' && i < s.length() - 1 && s.charAt(i + 1) == '/') {
                        mode = false;
                        i++;        // skip '/' on next iteration of i
                    }
                }
                else {
                    if (s.charAt(i) == '/' && i < s.length() - 1 && s.charAt(i + 1) == '/') {
                        break;      // case for "//"
                    }
                    else if (s.charAt(i) == '/' && i < s.length() - 1 && s.charAt(i + 1) == '*') {
                        mode = true;
                        i++;           // skip '*' on next iteration of i
                    }
                    else    sb.append(s.charAt(i));     //not a comment
                }
            }
            if (!mode && sb.length() > 0) {
                res.add(sb.toString());
                sb.setLength(0);   // reset for next line of source code
            }
        }
        return res;
    }
}
