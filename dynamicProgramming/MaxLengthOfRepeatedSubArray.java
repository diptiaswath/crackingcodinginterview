package dynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/maximum-length-of-repeated-subarray/solution/
public class MaxLengthOfRepeatedSubArray {


    // Time Complexity: O(M * N * min(M, N))
    // Space Complexity: O(N)
    public int findLengthA1(int[] nums1, int[] nums2) {
        int ans = 0;

        Map<Integer, ArrayList<Integer>> Bstarts = new HashMap();
        for (int j = 0; j < nums2.length; j++) {
            Bstarts.computeIfAbsent(nums2[j], x -> new ArrayList()).add(j);
        }

        System.out.println(" here = " + Bstarts);

        for (int i = 0; i < nums1.length; i++) {
            if (Bstarts.containsKey(nums1[i])) {
                for (int j: Bstarts.get(nums1[i])) {
                    int k = 0;
                    while (i+k < nums1.length && j+k < nums2.length && nums1[i+k] == nums2[j+k]) {
                        k++;
                    }
                    ans = Math.max(ans, k);
                }
            }
        }
        return ans;
    }

    // Time Complexity: O(M * N)
    // Space Complexity: O(N)
    // Dynamic Programming approach
    public int findLength(int[] nums1, int[] nums2) {
        int ans = 0;
        int[][] memo = new int[nums1.length + 1] [nums2.length + 1];
        for (int i = nums1.length - 1; i >= 0; i--) {
            for (int j = nums2.length - 1; j >=0; j--) {
                if (nums1[i] == nums2[j]) {
                    memo[i][j] = memo[i+1][j+1] + 1;
                }
                if (ans < memo[i][j]) {
                    ans = memo[i][j];
                }
            }
        }
        return ans;

    }
}
