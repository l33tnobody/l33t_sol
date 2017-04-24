public class Solution {
    private static String[] map = {" ", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<String>();
        if (digits.length() == 0) return res;
        StringBuilder sb=new StringBuilder();
        dtos(digits, 0, sb, res);
        return res;
    }

    void dtos(String digits, int index, StringBuilder sb, List<String> res) {
        if(index==digits.length()) {
            res.add(sb.toString());
            return;
        }

        char d=digits.charAt(index);
        String s = map[d - '0'];
        for(int i=0; i<s.length(); i++) {
            sb.append(s.charAt(i));
            dtos(digits, index+1, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

// iterative: 
public class Solution {
    private static String[] map = {" ", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<String>();
        if (digits.length() == 0) return res;

        res.add("");
        for(int i=0; i<digits.length(); i++) {
            List<String> newres = new ArrayList<>();

            String s = map[digits.charAt(i) - '0'];
            for (String comb : res) {
                for(int j=0; j<s.length(); j++) {
                    newres.add(comb + s.charAt(j));
                }
            }
            res = newres;
        }
        return res;
    }
}
