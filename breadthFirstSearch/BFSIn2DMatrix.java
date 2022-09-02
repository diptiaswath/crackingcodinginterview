package breadthFirstSearch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// NOTE: This BFS application uses a ArrayDeque
// https://leetcode.com/problems/shortest-path-in-binary-matrix/solution/
// Studied both approaches of overwriting grid[][] and without overwrites
// This approach is without overwrites
// Great example and explanation of BFS
// Great example and explanation of BFS
public class BFSIn2DMatrix {

    private int[][] directions = new int[][] { {-1,-1}, {-1,0}, {-1,1},
            {0,-1}, {0,0}, {0,1},
            {1,-1}, {1,0}, {1,1}
    };

    public int shortestPathBinaryMatrix(int[][] grid) {

        // First we need to check that the begin and target cells are open
        if (grid[0][0] != 0 || grid[grid.length -1] [grid[0].length-1] != 0) {
            return -1;
        }

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        // store grid[0][0] with a distance of 1
        queue.add(new int[] {0, 0, 1});
        visited[0][0] = true;

        // Now do BFS
        while(!queue.isEmpty()) {
            int[] cell = queue.remove();
            int row = cell[0];
            int col = cell[1];
            int distance = cell[2];

            // check if this is the target cell
            if (row == grid.length - 1 && col == grid[0].length -1) {
                return distance;
            }

            for (int[] neighbor : getNeighbor(row, col, grid)) {
                int neighborRow = neighbor[0];
                int neighborCol = neighbor[1];
                if (visited[neighborRow][neighborCol]) {
                    continue;
                }
                visited[neighborRow][neighborCol] = true;
                queue.add(new int[] {neighborRow, neighborCol, distance + 1});
            }
        }
        // target unreachable
        return -1;
    }

    private List<int[]> getNeighbor(int row, int col, int[][] grid) {
        List<int[]> neighbors = new ArrayList<>();
        for (int i = 0; i < directions.length; i++) {
            int newRow = row + directions[i][0];
            int newCol = col + directions[i][1];
            if (newRow < 0  || newCol < 0
                    || newRow >= grid.length
                    || newCol  >= grid[0].length
                    || grid[newRow][newCol] != 0) {
                continue;
            }
            neighbors.add(new int[] {newRow, newCol});
        }
        return neighbors;
    }
}
