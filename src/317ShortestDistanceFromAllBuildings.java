public class Solution {
    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int walk = 0; // to record the current common empty land
        int[][] neighbors = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int[][] dist = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] != 1) continue;

                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[]{i, j});
                int d = 0;
                while(!q.isEmpty()) {
                    int qsize = q.size();
                    d++;
                    for(int k=0; k<qsize; k++) {
                        int[] head = q.poll();
                        for(int[] nb : neighbors) {
                            int x = head[0] + nb[0];
                            int y = head[1] + nb[1];
                            if(x>=0 && x<m && y>=0 && y<n && grid[x][y] == walk) {
                                dist[x][y] += d;
                                grid[x][y]--; // prepare for the next walk and mark as visited
                                q.offer(new int[]{x, y});
                            }
                        }
                    }
                }
                walk--;
            }
        }

        int mindist = -1;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] != walk) continue;

                if(mindist<0 || mindist>dist[i][j]) {
                    mindist = dist[i][j];
                }
            }
        }

        return mindist;
    }
}

// more concised version saving the second pass
public class Solution {
    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int walk = 0; // to record the current common empty land
        int[][] neighbors = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] dist = new int[m][n];
        int mindist = -1;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] != 1) continue;

                mindist = -1;
                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[]{i, j});
                int d = 0;
                while(!q.isEmpty()) {
                    int qsize = q.size();
                    d++;
                    for(int k=0; k<qsize; k++) {
                        int[] head = q.poll();
                        for(int[] nb : neighbors) {
                            int x = head[0] + nb[0];
                            int y = head[1] + nb[1];
                            if(x>=0 && x<m && y>=0 && y<n && grid[x][y] == walk) {
                                dist[x][y] += d;
                                if (mindist == -1 || mindist > dist[x][y])
                                    mindist = dist[x][y];
                                grid[x][y]--; // prepare for the next walk and mark as visited
                                q.offer(new int[]{x, y});
                            }
                        }
                    }
                }
                walk--;
            }
        }

        return mindist;
    }
}
