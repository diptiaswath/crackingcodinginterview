// https://leetcode.com/problems/design-tic-tac-toe/
// Time Complexity: O(n), as for every move we are iterating over n cells,  4 times to check
// for each of the column, row, diagonal row, and anti-diagonal.
// This gives us time complexity of O(4⋅n) which is equivalent to O(n).
class TicTacToe {
    int[][] board;
    int n;
    public TicTacToe(int n) {
        this.board = new int[n][n];
        this.n = n;
    }

    public int move(int row, int col, int player) {
        board[row][col] = player;
        if (checkRow(row, player) || checkColumn(col, player) || (row == col && checkDiagonal(player)) ||
                (col == n - row -1 && checkAntiDiagonal(player))) {
            return player;
        }
        return 0;
    }

    private boolean checkRow(int row, int player) {
        for (int col = 0; col < n; col++) {
            if (board[row][col] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkColumn(int col, int player) {
        for (int row = 0; row < n; row++) {
            if (board[row][col] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonal(int player) {
        for (int row = 0; row < n; row++) {
            if (board[row][row] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkAntiDiagonal(int player) {
        for (int row = 0; row < n; row++) {
            if (board[row][n-row-1] != player) {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */