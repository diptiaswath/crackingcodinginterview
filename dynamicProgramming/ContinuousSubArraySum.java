// Use Prefix Sum and Hashmap
// https://leetcode.com/problems/continuous-subarray-sum/
// O(N)
// The problem asks us to determine if there exists a subarray in the given integer array nums where the sum of its elements is divisible by an integer k.
//Key Observations:
//
//The length of the subarray should be at least two.
//The constraints indicate that the problem must be solved in linear or log-linear time complexity, in terms of the size of the given array.
class Solution {
    // Is there a sub array whose sum is divisible by k?
    // And is the length of this sub array atleast 2, then return true
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> modSeen = new HashMap<>();
        modSeen.put(0, -1);

        int prefixMod = 0;
        for (int i = 0 ; i < nums.length; i++) {
            prefixMod = (prefixMod + nums[i]) % k;
            if (modSeen.containsKey(prefixMod)) {
                if (i - modSeen.get(prefixMod) > 1) {
                    return true;
                }
            } else {
                modSeen.put(prefixMod, i);
            }
        }
        return false;
    }
}
