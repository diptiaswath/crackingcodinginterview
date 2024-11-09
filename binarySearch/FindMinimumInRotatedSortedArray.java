// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/editorial/

class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left)/2;

            // If mid element is greater than the rightmost element,
            // the minimum is in the right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Otherwise, the minimum is in the left half (including mid)
                right = mid;
            }
        }
        // When left equals right, we have found the minimum element
        return nums[left];
    }
}

// TIP : DO NOT USE THE LEETCODE EDITORIAL SOLUTION. I asked chat gpt for this
// see the comments for tips