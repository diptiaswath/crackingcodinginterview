// https://leetcode.com/problems/longest-increasing-subsequence/
// O(n^2)
// dp[i] = Length of LIS ending at index i = Math.max(dp[j] + 1) for all j < i, where nums[j] < nums[i]
public int lengthOfLIS(int[] nums) {
    int[] dp = new int[nums.length];
    Arrays.fill(dp, 1);

    // Use DP
    for (int i = 1; i < nums.length; i++) {
        for (int j = 0; j < i; j++) { // TIP: see range of j
            if (nums[j] <= nums[i]) {
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
    }
    //
    int longest = 0;
    for (int c: dp) {
        longest = Math.max(longest, c);
    }

    return longest;
}


//O(n log n) with Binary Search
// 1. Initialize an array sub which contains the first element of nums.
// 2. Iterate through the input, starting from the second element. For each element num:

//If num is greater than any element in sub, then add num to sub.
//Otherwise, perform a binary search in sub to find the smallest element that is greater than or equal to num. Replace that element with num.
//Return the length of sub.

// https://leetcode.com/problems/longest-increasing-subsequence/description/
public int lengthOfLIS(int[] nums) {
    List<Integer> result = new ArrayList<>();
    result.add(nums[0]);

    for (int i = 1; i < nums.length; i++) {
        int num = nums[i];
        if (num > result.get(result.size()-1)) {
            result.add(num);
        } else {
            //replace the first element that is >= num with num
            int j = binSearch(num, result);
            result.set(j, num);
        }
    }
    return result.size();
}

private int binSearch(int num, List<Integer> result) {
    int left = 0;
    int right = result.size() - 1;

    while(left < right) {
        int mid = left + (right - left)/2;
        if (num == result.get(mid)) {
            return mid;
        }
        if (num > result.get(mid)) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    return left;
}
