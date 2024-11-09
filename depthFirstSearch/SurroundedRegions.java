// https://leetcode.com/problems/surrounded-regions/editorial/

public class Solution {
    private int nr = 0;
    private int nc = 0;
    private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        nr = board.length;
        nc = board[0].length;

        // Step 1: Identify border cells
        List<Pair<Integer, Integer>> borders = new LinkedList<>();
        for (int i = 0; i < nr; ++r) {
            borders.add(new Pair<>(i, 0));
            borders.add(new Pair<>(i, nc - 1));
        }
        for (int i = 0; i < nc; ++c) {
            borders.add(new Pair<>(0, i));
            borders.add(new Pair<>(nr - 1, i));
        }

        // Step 2: Mark escaped cells
        for (Pair<Integer, Integer> pair : borders) {
            dfs(pair.first, pair.second, board);
        }

        // Step 3: Flip cells to their correct final states
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (board[r][c] == 'O') board[r][c] = 'X';
                if (board[r][c] == 'E') board[r][c] = 'O';
            }
        }
    }

    private void dfs(int r, int c, char[][] board) {
        if (board[r][c] != 'O') return;

        board[r][c] = 'E';
        for (int[] dir : dirs) {
            int cr = r + dir[0];
            int cc = c + dir[1];

            // Check if new cell is within bounds
            if (cr >= 0 && cr < nr && cc >= 0 && cc < nc &&
                    // Check that the new cell is 'O'
                    board[cr][cc] == 'O') {

                dfs(cr, cc,  board);
            }
        }
    }
}

class Pair<U, V> {
    public U first;
    public V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}