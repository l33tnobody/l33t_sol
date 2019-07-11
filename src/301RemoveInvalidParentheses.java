public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> res = new HashSet<String>();
        int rmL=0, rmR=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='(') rmL++;
            else if(s.charAt(i)==')'){
                if(rmL!=0) rmL--;
                else rmR++;
            }
        }
        DFS(res, s, 0, rmL, rmR, 0, new StringBuilder());
        return new ArrayList<String>(res);
    }

    private void DFS(Set<String> res, String s, int i, int rmL, int rmR, int open, StringBuilder sb) {
        if(i==s.length() && rmL==0 && rmR==0 && open==0){
            res.add(sb.toString());
            return;
        }
        if(i==s.length()||rmL<0||rmR<0||open<0) return;

        char c = s.charAt(i);
        int len=sb.length();

        if (c=='('){
            DFS(res, s, i+1, rmL-1, rmR, open, sb);
            DFS(res, s, i+1, rmL, rmR, open+1, sb.append(c));
        }else if (c==')'){
            DFS(res, s, i+1, rmL, rmR-1, open, sb);
            DFS(res, s, i+1, rmL, rmR, open-1, sb.append(c));
        }else{
            DFS(res, s, i+1, rmL, rmR, open, sb.append(c));
        }

        sb.setLength(len);
    }
}



// https://leetcode.com/discuss/81478/easy-short-concise-and-fast-java-dfs-3-ms-solution
public List<String> removeInvalidParentheses(String s) {
    List<String> ans = new ArrayList<>();
    remove(s, ans, 0, 0, new char[]{'(', ')'});
    return ans;
}

public void remove(String s, List<String> ans, int last_i, int last_j,  char[] par) {
    int stack = 0;
    for (int i = last_i; i < s.length(); ++i) {
        if (s.charAt(i) == par[0]) stack++;
        if (s.charAt(i) == par[1]) stack--;
        if (stack < 0) {
            for (int j = last_j; j <= i; ++j) {
                if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1]))
                    remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par);
            }
            return;
        }
    }
    String reversed = new StringBuilder(s).reverse().toString();
    if (par[0] == '(')
        remove(reversed, ans, 0, 0, new char[]{')', '('});
    else
        ans.add(reversed);
}
