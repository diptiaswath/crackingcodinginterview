package depthFirstSearch;

// This is fully a DFS problem
// Time complexity : O(N)
// https://leetcode.com/problems/flood-fill/solution/

// Start from pixel identified by sr, sc. If color in that pixel is not the same as newColor, then start a DFS in 4 directions.
//  Let's floodfill the starting pixel: we change the color of that pixel to the new color,
// then check the 4 neighboring pixels to make sure they are valid pixels of the same color,
// and of the valid ones, we floodfill those, and so on.
public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor) dfs(image, sr, sc, color, newColor);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int color, int newColor) {
        if (image[r][c] == color) {
            image[r][c] = newColor;
            if (r >= 1) dfs(image, r-1, c, color, newColor);
            if (c >= 1) dfs(image, r, c-1, color, newColor);
            if (r+1 < image.length) dfs(image, r+1, c, color, newColor);
            if (c+1 < image[0].length) dfs(image, r, c+1, color, newColor);
        }
    }
}
