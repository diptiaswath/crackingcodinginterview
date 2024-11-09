//https://leetcode.com/problems/pacific-atlantic-water-flow/
class Solution {

    private int nr;
    private int nc;
    private int[][] landHeights;
    private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};


    private void dfs(int r, int c, boolean[][] reachable) {
        reachable[r][c] = true;

        for (int[] dir : dirs)  {
            int cr = r + dir[0];
            int cc = c + dir[1];

            // Check if new cell is within bounds
            if (cr >= 0 && cr < nr && cc >= 0 && cc < nc &&
                    // Check that the new cell hasn't already been visited
                    !reachable[cr][cc] &&
                    // Check that the new cell has a higher or equal height,
                    // So that water can flow from the new cell to the old cell
                    landHeights[cr][cc] >= landHeights[r][c]) {


                reachable[cr][cc] = true; // Mark as visited (if necessary)
                dfs(cr, cc, reachable);
            } // end of if
        }// end of for
    }



    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        // Check if input is empty
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        nr = matrix.length;
        nc = matrix[0].length;
        landHeights = matrix;

        boolean[][] pacificReachable = new boolean[nr][nc];
        boolean[][] atlanticReachable = new boolean[nr][nc];

        // Loop through each cell adjacent to the oceans and start a DFS
        for (int i = 0; i < nr; i++) {
            dfs(i, 0, pacificReachable);
            dfs(i, nc - 1, atlanticReachable);
        }
        for (int i = 0; i < nc; i++) {
            dfs(0, i, pacificReachable);
            dfs(nr - 1, i, atlanticReachable);
        }


        // Find all cells that can reach both oceans
        List<List<Integer>> commonCells = new ArrayList<>();
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    commonCells.add(List.of(i, j));
                }
            }
        }
        return commonCells;
    }



}