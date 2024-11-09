// https://leetcode.com/problems/next-permutation/editorial/?source=submission-ac
class NextPermutation {
    // HARD TO UNDERSTAND: Needs another pass

    public void nextPermutation(int[] nums) {
        // Step1. Find the first no decreasing element a[i-1] such that a[i] > a[i-1]
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }

        // Step2. Then, find the just largest element greater than that.
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            // Step3. Swap
            swap(nums, i, j);
        }

        // Step3. reverse the elements from i + 1
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}