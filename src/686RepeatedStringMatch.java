class Solution {
    public int repeatedStringMatch(String A, String B) {
        int q = 1;
        StringBuilder S = new StringBuilder(A);
        while(S.length() < B.length()) { S.append(A); q++; }
        if (S.indexOf(B) >= 0) return q; // kmp this to get O(m+n)
        if (S.append(A).indexOf(B) >= 0) return q+1; // at most, since all ending/beginning chars exist in the Source string
        return -1;
    }
}

