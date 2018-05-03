class Solution {
    public String addBoldTag(String s, String[] dict) {
        int n = s.length();
        boolean[] marked = new boolean[n];

        for(String word : dict) {
            int m = word.length();
            for(int i=0; i<=n-m; i++) { // this search here can be optimized with KMP
                if(s.startsWith(word, i)) {
                    for(int k=i; k<i+m; k++) {
                        marked[k] = true;
                    }
                }
            }
        }

        StringBuilder res = new StringBuilder();
        int i=0;
        while(i<n) {
            if(!marked[i]) {
                res.append(s.charAt(i));
                i++;
                continue;
            }
            int j=i+1;
            while(j<n && marked[j]) j++;
            res.append("<b>").append(s.substring(i, j)).append("</b>");
            i = j;
        }

        return res.toString();
    }
}
