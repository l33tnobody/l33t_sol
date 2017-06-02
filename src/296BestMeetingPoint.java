// sort based on position and sum on distance.
public class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> I = new ArrayList<>();
        List<Integer> J = new ArrayList<>();

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    I.add(i);
                    J.add(j);
                }
            }
        }

        return getDiff(I) + getDiff(J);
    }

    private int getDiff(List<Integer> l) {
        int res = 0;

        Collections.sort(l);
        int i = 0;
        int j = l.size() - 1;
        while(i<j) {
            res += l.get(j--) - l.get(i++);
        }

        return res;
    }
}

// Time Limit exceeds if trying to reuse the solution for 371 ShortestDistance
// to all buildings
public class Solution {
    public int minTotalDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] neighbors = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int[][] dist = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] != 1) continue;

                boolean[][] visited = new boolean[m][n];
                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[]{i, j});
                visited[i][j] = true; // dist to self is 0
                int d = 0;
                while(!q.isEmpty()) {
                    int qsize = q.size();
                    d++;
                    for(int k=0; k<qsize; k++) {
                        int[] head = q.poll();
                        for(int[] nb : neighbors) {
                            int x = head[0] + nb[0];
                            int y = head[1] + nb[1];
                            if(x>=0 && x<m && y>=0 && y<n && visited[x][y] == false) {
                                dist[x][y] += d;
                                visited[x][y] = true;
                                q.offer(new int[]{x, y});
                            }
                        }
                    }
                }
            }
        }

        int mindist = -1;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(mindist<0 || mindist>dist[i][j]) {
                    mindist = dist[i][j];
                }
            }
        }

        return mindist;
    }
}
