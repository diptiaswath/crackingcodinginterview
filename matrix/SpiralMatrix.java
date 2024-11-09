// https://leetcode.com/problems/spiral-matrix/submissions/1307612353/
// The loop continues until result contains all elements of the matrix (rows * columns).
// Left to Right: Traverse across the top boundary (up), from left to right. Add elements to result.
// Top to Bottom: Traverse down the right boundary (right), from up + 1 to down. Add elements to result.
// Right to Left (if applicable): Check if up is not equal to down. If true, traverse across the bottom boundary (down), from right - 1 to left. Add elements to result.
// Bottom to Top (if applicable): Check if left is not equal to right. If true, traverse up the left boundary (left), from down - 1 to up + 1. Add elements to result.
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rows = matrix.length;
        int columns = matrix[0].length;
        int up = 0;
        int left = 0;
        int right = columns - 1;
        int down = rows - 1;

        while (result.size() < rows * columns) {
            // Traverse from left to right.
            for (int col = left; col <= right; col++) {
                result.add(matrix[up][col]);
            }
            // Traverse downwards.
            for (int row = up + 1; row <= down; row++) {
                result.add(matrix[row][right]);
            }
            // Make sure we are now on a different row.
            if (up != down) {
                // Traverse from right to left.
                for (int col = right - 1; col >= left; col--) {
                    result.add(matrix[down][col]);
                }
            }
            // Make sure we are now on a different column.
            if (left != right) {
                // Traverse upwards.
                for (int row = down - 1; row > up; row--) {
                    result.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            up++;
            down--;
        }

        return result;
    }
}