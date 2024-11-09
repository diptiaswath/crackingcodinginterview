// https://www.educative.io/courses/grokking-coding-interview-patterns-java/solution-single-element-in-a-sorted-array
class SingleElement {
    public static int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (mid % 2 == 1) mid--;

            if (nums[mid] == nums[mid + 1]) {
                l = mid + 2;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }

}

// TIP: start < end and left = mid + 2 or right = mid.
// ALSO, note: if mid is odd, decrement to make it point to even element. when an element appears in pairs, first of pair appears at even index and second at odd index.
// If there is a single non duplicate that assumption is broken.


// BECAUSE:

// Check whether nums[mid] is the same as nums[mid + 1].
//
// If both are the same, it means that all elements up to this point were in pairs, and the single element
// must appear after mid. Therefore, move the left pointer toward the right. left = mid + 2
//
// If both are different, it means that the single element must have appeared before mid.
// Therefore, move the right pointer toward the left.