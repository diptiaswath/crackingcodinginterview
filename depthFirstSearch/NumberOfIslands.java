package depthFirstSearch;

// Uses DFS.
// https://leetcode.com/problems/number-of-islands/solution/
// Treat the 2d grid map as an undirected graph and there is an edge between two horizontally or vertically adjacent nodes of value '1'.
// This is ONLY DFS
public class NumberOfIslands {

    // Time O(m * n)
    private void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if ( r< 0 || c < 0|| r >= nr || c >= nc || grid[r][c] == '0' ) {
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;

        int numIslands = 0;
        for (int r = 0; r < nr; r++) {
            for (int c = 0; r < nc; c++) {
                if (grid[r][c] == '1') {
                    ++numIslands;
                    dfs(grid, r, c);
                }
            }
        }
        return numIslands;
    }
}


