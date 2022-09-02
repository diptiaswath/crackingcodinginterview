package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Does array contain duplicates. return true if yes, false if not.
public class Duplicate {

    //Approach1 O(n) because O(1) search and insert is repeated n times
    public boolean containsDuplicate(int[] nums) {
        boolean isDuplicate = false;
        Map<Integer, Integer> numCount = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            if (numCount.containsKey(nums[i])) {
                isDuplicate = true;
                return isDuplicate;
            }
            numCount.put(nums[i], count++);
        }
        return isDuplicate;
    }

    //Approach2 O(n log n)
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }
}
