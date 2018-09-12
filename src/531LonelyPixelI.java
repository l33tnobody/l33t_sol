class Solution {
    public int findLonelyPixel(char[][] picture) {
        int m = picture.length, n = picture[0].length;
        int[] rowcnt = new int[m];
        int[] colcnt = new int[n];
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(picture[i][j] == 'B') {
                    rowcnt[i]++;
                    colcnt[j]++;
                }
            }
        }
        
        int res = 0;
        for(int i=0; i<m; i++) {
            if(rowcnt[i] != 1) continue; // i can be 0 (no black pixel or) or > 1 which means all black pixels in this row is not "lonely"
            for(int j=0; j<n; j++) {
                if(picture[i][j] == 'B' && colcnt[j] == 1) res++;
            }
        }
        
        return res;
    }
}