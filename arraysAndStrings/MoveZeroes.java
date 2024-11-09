package arrays;

// https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/262/
class MoveZeroes {

    // Time complexity = O(n), Space = O(1)
    // The 2 requirements of the question are:
    //
    //    Move all the 0's to the end of array.
    //
    //    All the non-zero elements must retain their original order.
    public void moveZeroes(int[] nums) {
        int lastNonZeroIndex = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[lastNonZeroIndex++] = num;
            }
        }
        for (int i = lastNonZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
