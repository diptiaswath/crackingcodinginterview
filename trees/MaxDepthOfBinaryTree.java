
// https://leetcode.com/problems/maximum-depth-of-binary-tree/editorial/
public int maxDepth(TreeNode root) {
    if (root == null) {
        return 0;
    } else {
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // Since we're measuring the depth from the root node down to a leaf node, we need to account for the root node itself. Therefore, we add 1 to the maximum depth of its subtrees.
        return Math.max(leftDepth, rightDepth) + 1;
    }
}