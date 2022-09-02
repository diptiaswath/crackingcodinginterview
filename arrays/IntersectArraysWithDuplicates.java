package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/intersection-of-two-arrays-ii/solution/
public class IntersectArraysWithDuplicates {

    //https://leetcode.com/problems/intersection-of-two-arrays-ii/solution/
    // Approach O(n + m)
    //
    //
    //    If nums1 is larger than nums2, swap the arrays.
    //
    //    For each element in nums1:
    //
    //        Add it to the hash map m.
    //            Increment the count if the element is already there.
    //
    //    Initialize the insertion pointer (k) with zero.
    //
    //    Iterate along nums2:
    //
    //        If the current number is in the hash map and count is positive:
    //
    //            Copy the number into nums1[k], and increment k.
    //
    //            Decrement the count in the hash map.
    //
    //    Return first k elements of nums1.
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        // For the previous problem, we used a hash set to achieve a linear time complexity.
        // Here, we need to use a hash map to track the count for each number.

        // We collect numbers and their counts from one of the arrays into a hash map.
        // Then, we iterate along the second array, and check if the number exists in the hash map and its count is positive.
        // If so - add the number to the result and decrease its count in the hash map.
        // iterate over the smaller sized array and make a count map
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num: nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int k = 0;
        for (int num: nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                nums1[k++] = num;
                map.put(num, count--);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}
