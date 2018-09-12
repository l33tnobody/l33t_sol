class Solution {
    public int findBlackPixel(char[][] picture, int N) {
        int m = picture.length;
        int n = picture[0].length;
        Map<String, Integer> map = new HashMap<>(); // from a row signature to apprearing times
        int colcnt[] = new int[n];
        
        for(int i=0; i<m; i++) {
            String key = scanRow(picture, i, N, colcnt);
            if(key.length() != 0) map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        int res = 0;
        for(String k : map.keySet()) {
            if(map.get(k) == N) {
                for(int i=0; i<k.length(); i++) {
                    if(k.charAt(i) == 'B' && colcnt[i] == N) res += N;
                }
            }
        }
        
        return res;
    }
    
    public String scanRow(char[][] pic, int i, int N, int[] colcnt) {
        StringBuilder sb = new StringBuilder();
        int n = pic[0].length;
        int rowcnt = 0;
        
        for(int j=0; j<n; j++) {
            if(pic[i][j] == 'B') {
                rowcnt++;
                colcnt[j]++;
            }
            sb.append(pic[i][j]);
        }
        
        return rowcnt == N ? sb.toString() : "";
    }
}