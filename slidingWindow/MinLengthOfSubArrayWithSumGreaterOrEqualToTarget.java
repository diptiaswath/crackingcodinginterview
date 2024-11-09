// Given an array of positive integers, nums, and a positive integer, target, find the minimum length of a contiguous subarray
// whose sum is greater than or equal to the target. If no such subarray is found, return 0.

// This is from educative.io
class MinLengthOfSubArrayWithSumGreaterOrEqualToTarget {

    public static int minSubArrayLen(int target, int[] nums) {
        // Initializing windowSize to a max number
        int windowSize = Integer.MAX_VALUE;

        // Initialize start pointer to 0 and sum to 0
        int left = 0;
        int cur = 0;

        // Iterate over the input array
        for (int right= 0; right < nums.length; right++) {
            cur+= nums[right];
            // check if we can remove elements from the start of the subarray
            // while still satisfying the target condition
            while (cur >= target) {
                windowSize = Math.min(windowSize, right - left  + 1);
                cur -= nums[left];
                left += 1;
            }
        }

        if (windowSize != Integer.MAX_VALUE) {
            return windowSize;
        }
        return 0;

        //return 0;
    }
}