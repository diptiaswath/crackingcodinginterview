// https://leetcode.com/problems/search-a-2d-matrix/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix[0].length; // no of columns
        int n = matrix.length; // no of rows

        int left = 0; int right = (n * m -1);  // if you are to think of this as an array, no of elements in array is m * n -1
        while (left <= right) {
            int pivotIndex = left + (right - left)/2;
            int pivotElement = matrix[pivotIndex/n][pivotIndex%n]; // you get the row,column as index/n , index % n
            if (target == pivotElement) {
                return true;
            } else if (target < pivotElement) {
                right = pivotIndex - 1;
            } else {
                left = pivotIndex + 1;
            }
        }
        return false;
    }

}
//TIP: see the comments.

// Sorted array is a perfect candidate for the binary search because the element index in this virtual array
// (for sure we're not going to construct it for real) could be easily transformed into the row and column
// in the initial matrix

//row = idx // n and col = idx % n.