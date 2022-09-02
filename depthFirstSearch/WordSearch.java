package depthFirstSearch;

// This is a BACKTRACKING problem (with DFS)
// https://leetcode.com/problems/word-search/solution/
// Time Complexity: O(N⋅3^l)N is the number of cells in the board and L is the length of the word to be matched.

// For the backtracking function, initially we could have at most 4 directions to explore,
// but further the choices are reduced into 3 (since we won't go back to where we come from).
// Space Complexity: O(L) where L is the length of the word to be matched.

// https://leetcode.com/problems/word-search/solution/
public class WordSearch {

    private char[][] board;
    private int nr;
    private int nc;


    private boolean backTrack(int r, int c, String word, int index) {
        // step1. check the base case
        if (index >= word.length()) {
            return true;
        }

        // step2. check the boundaries
        if (r < 0 || r >= nr || c< 0 || c >= nc || board[r][c] != word.charAt(index)) {
            return false;
        }

        // step3. explore the neighbors with DFS
        boolean ret = false;
        this.board[r][c] = '#';

        int[] rowOffsets = {0, 1, 0, -1};
        int[] colOffsets = {1, 0, -1, 0};
        for (int i = 0; i < 4; i++) {
            ret = backTrack(r + rowOffsets[i], c + colOffsets[i], word, index + 1);
            if (ret) {
                break;
            };
        }

        // step4. clean up/revert and return result
        this.board[r][c] = word.charAt(index);
        return ret;
    }


    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.nr = board.length;
        this.nc = board[0].length;

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (backTrack(r, c, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }


}
