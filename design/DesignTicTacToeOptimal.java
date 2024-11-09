// https://leetcode.com/problems/design-tic-tac-toe/
// For a player to win, he/she should have marked either of the rows[row] or cols[col] or diagnal or antidiagonal n times.
// In this case, the check is O(1) and not O(4n)
class TicTacToe {
    int n;
    int diagonal = 0;
    int antiDiagonal = 0;
    int rows[];
    int cols[];
    public TicTacToe(int n) {
        //this.board = new int[n][n];
        this.n = n;
        rows = new int[n];
        cols = new int[n];
    }


    public int move(int row, int col, int player) {
        int curPlayer = (player == 1) ? 1: -1;
        rows[row] += curPlayer;
        cols[col] += curPlayer;
        if (row == col) {
            diagonal += curPlayer;
        }

        if (col == n - row - 1) {
            antiDiagonal += curPlayer;
        }

        if (Math.abs(rows[row]) == n ||
                Math.abs(cols[col]) == n || Math.abs(diagonal) == n || Math.abs(antiDiagonal) == n) {
            return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */