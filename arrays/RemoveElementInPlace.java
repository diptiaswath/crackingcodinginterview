package arrays;

//https://leetcode.com/problems/remove-element/
public class RemoveElementInPlace {

    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int i = 0;
        while ( i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n-1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        RemoveElementInPlace remove = new RemoveElementInPlace();

        System.out.println(remove.removeElement(nums, 3));
    }
}
