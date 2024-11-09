// https://leetcode.com/problems/number-of-islands/
// Time : O(m*n)
// Space: O(m*n)
class NumberOfIslandsBFS {
    int nr = 0;
    int nc = 0;
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private void bfs(char[][] grid, int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] dir: dirs) {
                int cr = cur[0] + dir[0];
                int cc = cur[1] + dir[1];

                if (cr >=0 && cr < nr && cc >=0 && cc < nc && grid[cr][cc] == '1') {
                    grid[cr][cc] = '0';
                    queue.offer(new int[]{cr, cc});
                }
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
                    bfs(grid, r, c);
                }
            }
        }
        return numOfIslands;
    }
}