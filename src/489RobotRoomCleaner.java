/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
class Solution {
    final int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();
        dfs(robot, visited, 0, 0, 0);
    }
    
    private void dfs(Robot robot, Set<String> visited, int curDirection, int row, int col) {
        visited.add(row + "," + col);
        robot.clean();
        
        for(int i = 0; i < 4; i++) {
            int direction = (curDirection + i) % 4;
            int[] next = directions[direction];
            int nextRow = row + next[0];
            int nextCol = col + next[1];
            
            if(!visited.contains(nextRow + "," + nextCol) && robot.move()) {
                dfs(robot, visited, direction, nextRow, nextCol);
                // recover the initial state here, best part:
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnLeft();
                robot.turnLeft();
            }
            robot.turnRight(); // need to turn clockwise to match the directions sequence
        }
    }
}