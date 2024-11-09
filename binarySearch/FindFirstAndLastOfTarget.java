// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
class FindFirstAndLastOfTarget {

    public int[] searchRange(int[] nums, int target) {
        int firstOccurence = findTarget(nums, target, true);
        if (firstOccurence == -1) {
            return new int[] {-1, -1};
        }
        int secondOccurence = findTarget(nums, target, false);
        return new int[]{firstOccurence, secondOccurence};
    }

    private int findTarget(int[] nums, int target, boolean first) {
        int begin = 0;
        int end = nums.length - 1;

        while (begin <= end) {
            int mid = begin + (end - begin)/2;

            if (nums[mid] == target) {
                if (first) {
                    if (mid == begin || nums[mid-1] != target) { // we have found the first occurence
                        return mid;
                    }
                    end = mid - 1; // search in first half
                } else {
                    if (mid == end || nums[mid+1] != target) {
                        return mid; // found the upper bound
                    }
                    begin = mid + 1;
                }
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        return -1;
    }
}