package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/permutations/
public class PermuteNums {

    // Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
    //
    // 1. If the first integer to consider has index n that means that the current         permutation is done.
    // 2. Iterate over the integers from index first to index n - 1.
    //    2.1. Place i-th integer first in the permutation, i.e. swap(nums[first], nums[i]).
    //    2.2 Proceed to create all permutations which starts from i-th integer : backtrack(first + 1).
    //    2.3 Now backtrack, i.e. swap(nums[first], nums[i]) back.

    private void permuteNums(List<Integer> nums,
                             int n,
                             List<List<Integer>> result,
                             int first) {
        if (first == n) {
            result.add(new ArrayList<Integer>(nums));
        }
        for (int i = first; i < n; i++) {
            // Place ith integer first in the current permuation
            Collections.swap(nums, first, i);
            // create all permutations starting with first + 1
            permuteNums(nums, n, result, first + 1);
            // backtrack
            Collections.swap(nums, first, i);
        }
    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> numsAsList = new ArrayList<>();
        for (int num : nums) {
            numsAsList.add(num);
        }
        permuteNums(numsAsList, numsAsList.size(), result, 0);
        return result;
    }
}
