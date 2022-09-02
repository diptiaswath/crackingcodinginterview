package arrays;

//https://leetcode.com/problems/maximum-subarray/
public class MaxSubArraySum {
    // Not all cases
    public int maxSubArray(int[] nums) {
        int maxSum = 0;
        int sum = 0;
        if (nums.length == 1) {
            return nums[0];
        }
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (maxSum < sum) {
                maxSum = sum;
            } else if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

    // O(n^2)
    public int maxSubArrayApproach2(int[] nums) {
            int maxSubArraySum = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                int curSubArraySum = 0;
                for (int j = i; j < nums.length; j++) {
                    curSubArraySum += nums[j];
                    maxSubArraySum = Math.max(maxSubArraySum, curSubArraySum);
                }
            }
            return maxSubArraySum;
    }

    // O(N)
    public int maxSubArrayApproach3(int[] nums) {
            int maxSubArraySum = nums[0];
            int curSubArraySum = nums[0];
            for (int i = 1; i < nums.length; i++) {
                // If current_subarray is negative, throw it away. Otherwise, keep adding to it.
                curSubArraySum = Math.max(nums[i], curSubArraySum + nums[i]);
                maxSubArraySum = Math.max(curSubArraySum, maxSubArraySum);
            }
            return maxSubArraySum;
    }
}
