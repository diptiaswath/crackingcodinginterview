package arrays;

public class RotateArray {

    // https://leetcode.com/problems/rotate-array/solution/
    // Approach1: rotate takes O(N * K), where k = num of times to rotate
    public void rotate1(int[] nums, int k) {
        if (nums.length == 0) {
            return;
        }
        k %= nums.length;
        int prev, temp;
        for (int i = 0; i < k; i++) {
            prev = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = prev;
                prev = temp;
            }
        }
    }

    // Approach2: rotate takes O(N) time by using another array
    public void rotate2(int[] nums, int k) {
        if (nums.length == 0) {
            return;
        }
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }

}
