package arrays;

import java.util.HashMap;
import java.util.Map;

class TwoSum {
    // https://leetcode.com/problems/two-sum/solution/
    // Approach 1: O(n^2)
    // Loop through each element xxx and find if there is another
    // value that equals to target−x.
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    // Approach 2: Two Pass Hash. Does not use constant space
    public int[] twoSumHash(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] {i, map.get(complement)};
            }
        }
        return null;
    }

    // Approach 3: Two Pass sum in a sorted array. Constraint to use constant space
    public int[] twoSumWithConstantSpace(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[] {left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[] { -1, -1 };
    }
}
