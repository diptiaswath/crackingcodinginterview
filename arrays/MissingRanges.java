package arrays;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/missing-ranges/solution/
public class MissingRanges {

    // when nums[i] - nums[i-1] == 1, then there are no missing elements
    // when nums[i] - nums[i-1] > 1, then there is missing range between (num[i-1] + 1, num[i] - 1)
    // when array does not start at lower, then missing range between (lower, nums[0] - 1)
    // when array does not end at upper, then missing range between (nums[n-1] +1, upper)
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        int prev = lower - 1;
        for (int i = 0; i <= nums.length; i++) {
            int curr = (i < nums.length? nums[i] : upper + 1);
            System.out.println("prev = " + prev + " curr = " + curr);
            if (prev + 1 <= curr - 1) {

                result.add(formatRange(prev + 1, curr - 1));
            }
            prev = curr;
        }
        return result;
    }

    private String formatRange(int lower, int upper) {
        if (lower == upper) {
            return String.valueOf(lower);
        }
        return lower + "->" + upper;
    }
}
