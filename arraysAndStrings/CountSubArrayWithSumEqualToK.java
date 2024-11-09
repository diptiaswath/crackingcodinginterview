// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
// A subarray is a contiguous non-empty sequence of elements within an array.

// https://leetcode.com/problems/subarray-sum-equals-k/description/

class CountSubArrayWithSumEqualToK {
    // Brute Force
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    // O(n)
    public int countOfSubArraysWithSumEqualToK(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int sum = 0, count = 0;
        countMap.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (countMap.contains(sum - k)) {
                count += countMap.get(sum - k);
            }
            countMap.put(sum, countMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }



}