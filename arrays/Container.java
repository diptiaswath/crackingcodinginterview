package arrays;

public class Container {

    // https://leetcode.com/problems/container-with-most-water/solution/
    // O(n^2)
    // area of container rectangle = height[i] where height[i] is shorter vertical line * width between lines
    public int maxAreaApproach1(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int width = j - i;
                maxArea = Math.max(maxArea,
                        Math.min(height[i], height[j]) * width);
            }
        }
        return maxArea;
    }

    //area of the container is always formed by the shorter line's length.
    // O(n)
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int width = right - left;
            maxArea = Math.max(maxArea,
                    Math.min(height[left], height[right]) * width);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
