package arrays;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/summary-ranges/
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> output = new ArrayList<>();
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            i = j;
            while (j+1 < nums.length && nums[j + 1] == nums[j] + 1) {
                j++;
            }

            if (i == j) {
                output.add("" + nums[i] + "");
            } else {
                output.add(nums[i] + "->" + nums[j]);
            }
        }
        return output;

    }
}
