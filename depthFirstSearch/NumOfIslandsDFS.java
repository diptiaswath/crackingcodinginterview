//https://leetcode.com/problems/number-of-islands/description/
// ime complexity : O(M×N) where M is the number of rows and N is the number of columns.
class NumOfIslandsDFS {
    int nr = 0;
    int nc = 0;
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private void dfs(char[][] grid, int r, int c) {
        for (int[] dir: dirs) {
            int cr = r + dir[0];
            int cc = c + dir[1];

            if (cr >=0 && cr < nr && cc >=0 && cc < nc && grid[cr][cc] == '1') {
                grid[cr][cc] = '0';
                dfs(grid, cr, cc);
            }
        }
    }

    public int numIslands(char[][] grid) {
        this.nr = grid.length;
        this.nc = grid[0].length;
        int numOfIslands = 0;

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    ++numOfIslands;
                    dfs(grid, r, c);
                }
            }
        }
        return numOfIslands;
    }
}