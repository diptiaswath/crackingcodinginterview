// Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
// You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
// Approach: you get n = # of elements in nums
// for each num in nums (> 0 but <=n) set seen[num] = true
// iterate i through 1 to n inclusive, if seen[i] = false, that is the smallest positive
// else; if seen contains all elements 1 to n, then return n + 1 as the smallest positive

// https://leetcode.com/problems/first-missing-positive/editorial/
class FirstMissingPositive {
    public int findMissingInUnsorted(int[] nums) {
        int n = nums.length;
        boolean[] seen = new boolean[n + 1];

        for (int num: nums) {
            if (num > 0 && num <= n) {
                seen[num] = true;
            }
        }
        for (int i = 1; i <=n ; i++) {
            if (!seen[i]) {
                return i;
            }
        }
        return n + 1;
    }
}