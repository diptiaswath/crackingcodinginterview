package depthFirstSearch;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/robot-room-cleaner/solution/
// This is an example where Spiral BACKTRACKING strategy is applied
interface Robot {
    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
    public boolean move();

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    public void turnLeft();
    public void turnRight();

    // Clean the current cell.
    public void clean();
}

class Pair<K, V> {
    K key;
    V value;
    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
public class RobotCleaner {
    private Robot robot;
    private int[][] directions = new int[][] {{-1, 0} , {0, 1}, {1, 0}, {0, -1}};
    private Set<Pair<Integer, Integer>> visited = new HashSet();

    private void goBack() {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    // Backtrack(cell = (0, 0), direction = 0)

    // Mark the cell as visited and clean it up.
    // Explore 4 directions : up, right, down, and left (the order is important since the idea is always to turn right) :
    // Check the next cell in the chosen direction :
    //     If it's not visited yet and there is no obstacles :
    //        1. Move forward.
    //        2. Explore next cells backtrack(new_cell, new_direction).
    //        3. Backtrack, i.e. go back to the previous cell.
    //     Turn right because now there is an obstacle (or a virtual obstacle) just in front.
    private void backTrack(int row, int col, int d) {
        visited.add(new Pair<Integer, Integer>(row, col));
        robot.clean();

        // explore 4 directions: up, right, down, left
        for (int i = 0; i < 4; i++) {
            int newD = (d + i) % 4;
            int newRow = row + directions[newD][0];
            int newCol = col + directions[newD][1];

            if (!visited.contains(new Pair<Integer, Integer>(newRow, newCol)) && robot.move()) {
                backTrack(newRow, newCol, newD);
                goBack();
            }

            // turn the Robot following chosen direction : clockwise
            robot.turnRight();
        }
    }

    public void cleanRoom(Robot robot) {
        this.robot = robot;
        backTrack(0, 0, 0);
    }
}
