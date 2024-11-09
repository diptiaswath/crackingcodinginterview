// https://leetcode.com/problems/max-area-of-island/
class Solution {
    int nr = 0;
    int nc = 0;

    boolean[][] visited;

    private int dfs(int[][] grid, int r, int c) {
        if (r < 0 || r >= nr || c < 0 || c >= nc ||
                visited[r][c] || grid[r][c] == 0) {
            return 0;
        }
        visited[r][c] = true;
        return (1 + dfs(grid, r+1, c) + dfs(grid, r-1, c) + dfs(grid, r, c -1) + dfs(grid, r, c+1));
    }

    public int maxAreaOfIsland(int[][] grid) {
        nr = grid.length;
        nc = grid[0].length;
        visited = new boolean[nr][nc];
        int maxArea = 0;
        for (int r = 0 ; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                maxArea = Math.max(maxArea, dfs(grid, r, c));
            }
        }
        return maxArea;
    }
}

// TIP: HARD ONE - DID NOT UNDERSTAND WELL ENOUGH, make sure you cover NumOfIslandsDFS and PacAtlWaterFlow with this