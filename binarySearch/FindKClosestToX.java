// Facebook MOCK asked me this
// 1. Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array.
// The result should also be sorted in ascending order. An integer a is closer to x than an integer b if: |a - x| < |b - x|, or |a - x| == |b - x| and a < b

// Look at educative.io for the less optimal solution - to understand this problem
// https://www.educative.io/courses/grokking-coding-interview-patterns-java/find-k-closest-elements
// This is the optimal solution
class FindKClosestToX {

    // The binary search part takes O(log(n - k)), which simplifies to O(log n) since k is typically much smaller than n.
    // Adding k elements to the result list takes O(k).
    //Therefore, the overall time complexity is O(log n + k), which is much more efficient than the O(n log n) approach with sorting.
    public List<Integer> findKClosestToTarget(int[] nums, int k, int x) {
        List<Integer> closest = new ArrayList<>();

        int left = 0;
        int right = nums.length - k;

        // find the index of the start element such that all elements from start are closest to x
        while (left < right) {
            int mid = left + (right - left)/2;
            if ((x - nums[mid]) > (nums[mid + k] - x)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // add k closest elements from start
        for (int i = left; i < left + k; i++) {
            closest.add(nums[i]);
        }

        return closest;
    }
}

// TIP: start < end and end = mid;
// Explanation of Handling |a - x| == |b - x| and a < b:
// Binary Search Comparison:
//
//The condition x - arr[mid] > arr[mid + k] - x ensures that if two elements are equally distant from x,
//the smaller element (which appears earlier in the sorted array) will be preferred.
// This is because if x - arr[mid] is not greater, we include the element at mid in our potential window.