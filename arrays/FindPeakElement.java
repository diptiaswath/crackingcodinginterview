package arrays;

public class FindPeakElement {
    //https://leetcode.com/problems/find-peak-element/solution/

    // Make use of the pattern that nums[i] is always greater than nums[i+1]
    public int findPeakElementInON(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            if ((nums[i] > nums[i + 1]) && (nums[i] > nums[i-1])) {
                return i;
            }
        }
        return -1;
    }

    private int search(int[] nums, int l, int r) {
        if (l == r) {
            return l;
        }
        int mid = (l+r)/2;
        if (nums[mid] > nums[mid+1]) {
            return search(nums, l, mid);
        }
        return search(nums, mid + 1, r);
    }

    public int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }
}
