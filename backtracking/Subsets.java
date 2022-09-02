package backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/subsets/solution/
// ex: nums = [1, 2, 3]
// output = [[], [1], [2], [3], [1, 2], [1,3] [2, 3], [1,2, 3]
public class Subsets {

    private int n , k;
    private List<List<Integer>> output = new ArrayList<>();


    // Time complex: O(N * 2 ^ n)
    // iterate over all possible lengths from 0 to including n
    // generate all subsets of length 0
    // generate all subsets of length 1
    // ..
    // generate all subsets of length n

    private void backtrack(int first, List<Integer> curr, int[] nums) {
        if (curr.size() == k) {
            output.add(new ArrayList<>(curr));
        }

        for (int i = first; i < n; i++) {
            curr.add(nums[i]);
            backtrack(i + 1, curr, nums);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        for (k = 0; k <= n; k++) {
            backtrack(0, new ArrayList<>(), nums);
        }
        return output;
    }
}

