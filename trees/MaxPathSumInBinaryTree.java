// https://leetcode.com/problems/binary-tree-maximum-path-sum/editorial/
public class MaxPathSumInBinaryTree {
    private int maxSum;

    public int maxPathSumInBinaryTree(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        gainFromSubtree(root);
        return maxSum;
    }

    // post order traversal of subtree rooted at `NODE`
    private int gainFromSubtree(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // if we get a negative value for leftPathSum or rightPathSum, then computing this max by comparing with 0 helps
        int maxLeftGain = Math.max(0, gainFromSubtree(node.left));
        int maxRightGain = Math.max(0, gainFromSubtree(node.right));

        // if left or right path sum are negative, they are counted
        // as 0, so this statement takes care of all four scenarios
        maxSum = Math.max(maxSum, maxLeftGain + maxRightGain + node.val);

        // return the max sum for a path starting at the root of subtree
        return Math.max(maxLeftGain + node.val, maxRightGain + node.val); // Max Gain from SUBTREE
    }
}


