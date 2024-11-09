// Use the educative.io solution. Easier to understand
// https://www.educative.io/courses/grokking-coding-interview-patterns-java/solution-search-in-rotated-sorted-array
// https://leetcode.com/explore/interview/card/facebook/54/sorting-and-searching-3/279/
class SearchInRotatedArray {
    private int recurseBinarySearch(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start)/2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[start] <= nums[mid]) { // first half of array is sorted
            if (target >= nums[start] && target < nums[mid]) { // search for target within first half
                return recurseBinarySearch(nums, target, start, mid - 1);
            }
            return recurseBinarySearch(nums, target, mid + 1, end); // else, search for target in second half
        } else {
            if (target > nums[mid] && target <= nums[end]) {
                return recurseBinarySearch(nums, target, mid + 1, end);
            }
            return recuseBinarySearch(nums, target, start, mid - 1);
        }
    }

    public int search(int[] nums, int target) {
        return recurseBinarySearch(nums, target, 0, nums.length - 1);
    }

}

// TIP, if start > end, return -1. Recursive bin search. If nums[start] <= nums[mid]. left = mid + 1 or right = mid - 1