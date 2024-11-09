// https://leetcode.com/problems/set-matrix-zeroes/ - IN PLACE
// Approach:
// If a cell entry is 0, record the row, col
// Run through each cell again, if matrix[i] [j] == 0, check if i or j appears in the seen row or column set. If yes, set the entry to 0
class Solution {
    public void setZeroes(int[][] matrix) {
        int nr = matrix.length;
        int nc = matrix[0].length;
        Set<Integer> markedRows = new HashSet<>();
        Set<Integer> markedCols = new HashSet<>();

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (matrix[i][j] == 0) {
                    markedRows.add(i);
                    markedCols.add(j);
                }
            }
        }
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (markedRows.contains(i) || markedCols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }

    }
}