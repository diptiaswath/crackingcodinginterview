// The N-Queens puzzle is the famous problem of placing n queens on an n x n chessboard such that no two queens attack each other. Given an integer n, return the number of distinct solutions to the N-Queens puzzle.
// https://leetcode.com/explore/interview/card/leetcodes-interview-crash-course-data-structures-and-algorithms/711/backtracking/4537/
class NQueens {
    // Place n queens on a chess board of size n * n such that no two queens attack each other.
    // One queen can be attacked by another queen if they share the same row, column, or diagonal.

    // The true time complexity of this algorithm isn't actually known, but it's approximately

    //O(n!). The argument is that the first call will consider n options. The next call will consider n - 2 options, because one square will occupy the same column, and at least one square will occupy a diagonal/anti diagonal. The pattern continues, as the next call after that will consider n - 4 squares and so on. The space complexity is
    //O(n) due to the sets and the recursion call stack.
    private int backtrack(int row, int size, Set<Integer> columns, Set<Integer> diagonals, Set<Integer> antiDiagonals) {
        int solutions = 0;

        if (row == size) {
            return 1;
        }
        for (int col = 0; col < size; col++) {
            int curDiagonal = row - col;
            int curAntiDiagnoal = row + col;

            // If the queen is not placeable since there's another queen
            if (columns.contains(col) || diagonals.contains(curDiagonal) || antiDiagonals.contains(curAntiDiagnoal)) {
                continue;
            }
            // Add the queen to the board
            columns.add(col);
            diagonals.add(curDiagonal);
            antiDiagonals.add(curAntiDiagnoal);

            // Move on to the next row with the updated board state
            solutions += backtrack(row + 1, size, columns, diagonals, antiDiagonals);

            // "Remove" the queen from the board since we have already
            // explored all valid paths using the above function call
            columns.remove(col);
            diagonals.remove(curDiagonal);
            antiDiagonals.remove(curAntiDiagnoal);
        }
    }

    public int nqueens(int n) {
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonals = new HashSet<>();
        Set<Integer> antiDiagonals = new HashSet<>();

        return backtrack(0, n,columns, diagonals, antiDiagonals);
    }
}