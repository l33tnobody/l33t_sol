// trace back from bottom right corner and calculate "need"
// note: does not work from top left  down right with this logic
public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] needs = new int[m+1][n+1];
        for(int i=0; i<n+1; i++){
            needs[m][i] = Integer.MAX_VALUE;
        }
        for(int j=0; j<m+1; j++){
            needs[j][n] = Integer.MAX_VALUE;
        }
        needs[m-1][n] = 1;
        needs[m][n-1] = 1;

        for (int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                needs[i][j] = Math.max(Math.min(needs[i+1][j], needs[i][j+1]) - dungeon[i][j], 1);
            }
        }

        return needs[0][0];
    }
}

// one row is good enough to do dp:
public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[] needs = new int[n+1];
        for(int i=0; i<n+1; i++){
            needs[i] = Integer.MAX_VALUE;
        }

        needs[n-1] = 1;

        for (int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                needs[j] = Math.max(Math.min(needs[j], needs[j+1]) - dungeon[i][j], 1);
            }
        }

        return needs[0];
    }
}
