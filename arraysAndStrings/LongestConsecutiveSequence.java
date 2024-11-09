// https://leetcode.com/problems/longest-consecutive-sequence/editorial/
// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
// You must write an algorithm that runs in O(n) time.
// https://leetcode.com/problems/longest-consecutive-sequence/description/
class Solution {
    // Approach1 - O(n log n)
    public int longestConsecutiveOLOGN(int[] nums) {
        Arrays.sort(nums);
        int longest = 1;
        int current = 1;
        for (int i =1; i < nums.length; i++) {

            if (nums[i]!=nums[i-1]) {
                if (nums[i] == nums[i-1] + 1) {
                    current +=1;
                } else {
                    longest = Math.max(longest, current);
                    current = 1;
                }
            }

        }
        return Math.max(longest, current);
    }

    // Approach2: O(n)
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num: nums) {
            numSet.add(num);
        }

        int longest = 0;
        for (int num: nums) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int current = 1;

                while(numSet.contains(currentNum + 1)) {
                    current += 1;
                    currentNum += 1;
                } // while
                longest = Math.max(current, longest);
            } // if
        }// for

        return longest;
    }
}