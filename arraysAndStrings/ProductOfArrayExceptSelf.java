public class ProductOfArrayExceptSelf {
    // https://leetcode.com/problems/product-of-array-except-self/
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;

        int[] L = new int[length];
        int[] R = new int[length];
        int[] answer = new int[length];

        //Step1. For an index i, its L[i] = product of all elements to its left
        // L[i] = L[i-1] * nums[i-1]
        L[0] = 1; // trick
        for (int i = 1; i < nums.length; i++) { // start at i = 1
            L[i] = L[i-1] * nums[i-1];
        }

        //Step2. For an index i, its R[i] = product of all elements to its right
        //R[i] = R[i+1] * nums[i+1]
        R[nums.length -1] = 1; // trick
        for (int i = nums.length - 2; i >=0; i--) { // start at i = nums.length - 2
            R[i] = R[i+1] * nums[i+1];
        }
        for (int i = 0 ; i < nums.length; i++) {
            answer[i] = L[i] * R[i];
        }
        return answer;
    }
}