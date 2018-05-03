class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        String path="";
        helper(s, 0, 0, path, res);
        return res;
    }

    // si: the current index of char in String s, pn: current index of parts being filled
    private void helper(String s, int si, int pn, String path, List<String> res) {
        if(s.length() - si > 3 * (4-pn) || s.length() - si < 1 * (4-pn))  return; // chars left too many or too few

        if(si == s.length() && pn == 4) {
            //resize -1 to remove '.'
            res.add(path.substring(0, path.length()-1));
            return;
        }

        int num=0;
        for(int i = si; i < si+3 && i < s.length(); i++){
            num = num*10 + (s.charAt(i) - '0');

            if(num > 255) break;
            path += s.charAt(i);
            helper(s, i+1, pn+1, path+'.', res);

            if(num==0) break;   //no 0xx
        }
    }
}
