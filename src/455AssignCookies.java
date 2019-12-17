class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int j = 0;
        for(int i=0; i<s.length && j<g.length; i++) {
            if(s[i] >= g[j]) j++;
        }

        return j;
    }
}

// or do it the reverse way:
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int j = s.length - 1;
        for (int i = g.length - 1; i >= 0 && j >= 0; i--) {
            if (s[j] >= g[i])
                j--;
        }

        return s.length - 1 - j;
    }
}