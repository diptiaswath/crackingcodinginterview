package arrays;

public class FindIndexOfPeakElement {
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

    // recursive binary search
    private int search(int[] nums, int l, int r) {
        if (l == r) {
            return l;
        }
        int mid = (l+r)/2;
        if (nums[mid] > nums[mid+1]) { //if num[mid] > nums[mid+1], it means this number is on a descending sequence of #s, so search in left half
            return search(nums, l, mid);
        }
        return search(nums, mid + 1, r); // it implies peak is on right side since nums[mid] < nums[mid + 1]
    }

    public int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }


    // iterative binary search
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + (right - left) / 2);
            if (nums[mid] > nums[mid +1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    TIP: USE THE ITERATIVE BIN SEARCH.
        1. if nums[mid] > nums[mid+1] it means nums has a decreasing sequence, so all peak elements now should be on left of array
        2. you are returning index of peak element
}
