// https://leetcode.com/problems/3sum/editorial/
// Uses TwoSum with HashSet
class ThreeSum {

    private void twoSum(int[] nums, int i, List<List<Integer>> res) {
        Set<Integer> seen = new HashSet<>();
        for (int j = i+1; j< nums.length; j++) {
            int complement = -nums[i]-nums[j];
            if (seen.contains(complement)) {
                res.add(Arrays.asList(nums[i], nums[j], complement));
                while (j + 1 < nums.length && nums[j] == nums[j+1]) {
                    j++;
                }
            }
            seen.add(nums[j]);
        }
    }


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && nums[i] <=0; i++) {
            if (i == 0 || (nums[i-1] != nums[i])) {
                twoSum(nums, i, res);
            }
        }
        return res;
    }
}