public class Solution {
    private static String[] map = {" ", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> res=new ArrayList<String>();
        StringBuilder sb=new StringBuilder();
        dtos(digits,0,sb,res);
        return res;
    }
    
    void dtos(String digits, int index, StringBuilder sb, ArrayList<String> res){
        if(index==digits.length()){
            res.add(sb.toString());
            return;
        }
        
        char d=digits.charAt(index);
        String s=map[d-'0'];
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            dtos(digits, index+1, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
