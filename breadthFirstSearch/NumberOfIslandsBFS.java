package breadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

//Uses BFS.
//https://leetcode.com/problems/number-of-islands/solution/
public class NumberOfIslandsBFS {

    public int numOfIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int numOfIslands = 0;

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    ++numOfIslands;

                    // start BFS
                    grid[r][c] = '0'; // mark as visited
                    Queue<Integer> queue = new LinkedList<Integer>();
                    queue.add(r * nc + c);
                    while (!queue.isEmpty()) {
                        int neighbor = queue.remove();
                        int neighborRow = neighbor/nc;
                        int neighborCol = neighbor % nc;

                        if (neighborRow - 1 >= 0 && grid[neighborRow - 1][neighborCol] != '0') {
                            queue.add((neighborRow - 1) * nc + neighborCol);
                            grid[neighborRow -1][neighborCol] = '0';
                        }
                        if (neighborRow + 1 < nr && grid[neighborRow + 1][neighborCol] != '0') {
                            queue.add((neighborRow + 1) * nc + neighborCol);
                            grid[neighborRow + 1][neighborCol] = '0';
                        }
                        if (neighborCol - 1 >= 0 && grid[neighborRow][neighborCol - 1] != '0') {
                            queue.add(neighborRow * nc + (neighborCol - 1));
                            grid[neighborRow][neighborCol - 1] = '0';
                        }
                        if (neighborCol + 1 < nc && grid[neighborRow][neighborCol + 1] != '0') {
                            queue.add(neighborRow * nc + (neighborCol + 1));
                            grid[neighborRow][neighborCol + 1] = '0';
                        }
                    } // while queue is not empty

                } // if-loop
            } // for c-loop
        } // for r-loop
        return numOfIslands;
    }

}

