public class Solution {
    public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();

        while (n>0){
            --n;
            int d = n%26;
            char D = (char)('A'+d);
            res.insert(0, D);
            n/=26;
        }
        return res.toString();
    }
}
