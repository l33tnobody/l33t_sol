class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        helper(S, 0, "", res);
        return res;
    }

    private void helper(String S, int index, String str, List<String> res) {
        if(index == S.length()) {
            res.add(str);
            return;
        }

        char c = S.charAt(index);
        if(Character.isDigit(c)) {
            helper(S, index+1, str + c, res);
            return;
        }

        helper(S, index + 1, str + Character.toLowerCase(c), res);
        helper(S, index + 1, str + Character.toUpperCase(c), res);
    }
}
