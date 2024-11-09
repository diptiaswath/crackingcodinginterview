// https://leetcode.com/problems/longest-increasing-subsequence/
// O(n^2)
public int lengthOfLIS(int[] nums) {
    List<Integer> result = new ArrayList<>();
    result.add(nums[0]);

    for (int i = 1; i < nums.length; i++) {
        int num = nums[i];
        if (num > result.get(result.size()-1)) {
            result.add(num);
        } else {
           int j = 0;
           // increment j as long as num is greater, but as soon as you find the first element in result that is greater than num, stop and get that jth index
           while (num > result.get(j)) {
               j++;
           }
           // replace element at jth index to be num
           result.set(j, num);
        }
    }
    return result.size();
}