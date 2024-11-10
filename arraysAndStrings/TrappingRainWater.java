package arrays;

//https://leetcode.com/problems/trapping-rain-water/solution/
//For each element in the array, we find the maximum level of water it can trap after  the rain,
// which is equal to the minimum of maximum height of bars on both the sides minus its own height.

// Approach1 with DP: Time complexity : O(n),
// Space complexity: O(n)

// Approach2 with 2 pointers: Time complexity: O(n),
// Space complexity: O(1)
public class TrappingRainWater {


    // Algorithm for approach1:
    //Find maximum height of bar from the left end upto an index i in the array left_max.
    //Find maximum height of bar from the right end upto an index i in the array right_max.
    //Iterate over the height array and update ans:
    //Add min (leftMax[i], rightMax[i]) - height[i] to ans


    //arr[] = {3, 0, 2, 0, 4}

        //Approach1: O(n^2)
        // Explanation: https://www.geeksforgeeks.org/trapping-rain-water/
        //
        public int trap(int[] height) {
            int result = 0;

            // for each element, except the first and last element
            for (int i = 1; i < height.length - 1; i++) {

                // find max element on left
                int leftMax = height[i];
                for (int j = 0; j < i; j++) {
                    leftMax = Math.max(leftMax, height[j]);
                }

                // find max element on right
                int rightMax = height[i];
                for (int j = i; j < height.length; j++) {
                    rightMax = Math.max(rightMax, height[j]);
                }
                // Update max water that can be trapped at each element
                result += Math.min(leftMax, rightMax) - height[i];
            }

            return result;
        }


    // So, we can say that if there is a larger bar at one end (say right),
    // we are assured that the water trapped would be dependant on height of bar in current direction (from left to right).
    // As soon as we find the bar at other end (right) is smaller, we start iterating in opposite direction (from right to left).
    // With 2 pointers
    public int trapApproach2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int ans = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    ans += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    ans += rightMax - height[right];
                }
                right--;
            }
        }
        return ans;
    }

}
