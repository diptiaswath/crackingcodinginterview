package arrays;

public class RemoveElement {
    // https://leetcode.com/problems/remove-element/
    public int removeElement(int[] nums, int val) {
        int k = nums.length;
        int i = 0;
        while (i < k) {
            if (nums[i] == val) {
                nums[i] = nums[k-1];
                k--;
            } else {
                i++;
            }
        }
        System.out.println("k = " + k);
        return k;
    }
}
