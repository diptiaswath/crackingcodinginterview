package arrays;

// Uses Range based binary search.
// Keep track of the highest valued element in nums as low
// Keep track of max sum of nums as high

// Chose max allowed subset sum (mid) and find the no of subsets that can be formed.
// 1) if no of subsets formed > M
//      -- increase max allowed subset sum : update low ptr
//      -- decrease max allowed subset sum: update high ptr
public class SplitArrayLargestSum {

    // https://www.youtube.com/watch?v=l4oWjLazNhU - explanation video
    // Time complexity: O(N log S), s = sum of integers in array. n = length of array.
    // For each binary search iteration that takes log (S) time, N * log S
    public int splitArrayLargestSum(int[] nums, int m) {
            int maxNo = 0;
            int total = 0;
            for (int num : nums) {
                maxNo = Math.max(maxNo, num);
                total += num;
            }

            int low = maxNo;
            int high = total; //max allowed subset sum
            while (low < high) {
                int mid = low + (high - low)/2;
                if (validSplitPossible(mid, nums, m)) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
    }

        private boolean validSplitPossible(int maxPossibleSum, int[] nums, int m) {
            int totalSubsetCount = 1;
            int totalRunningSum = 0;

            for (int num : nums) {
                totalRunningSum += num;
                if (totalRunningSum > maxPossibleSum) {
                    totalRunningSum = 0;

                    totalRunningSum = num;

                    totalSubsetCount += 1;

                    if (totalSubsetCount > m) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
