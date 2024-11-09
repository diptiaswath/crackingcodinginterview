// https://leetcode.com/problems/count-good-nodes-in-binary-tree/
// O(N)
// Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
// Return the number of good nodes in the binary tree.

// Check out the video - best explanation
class Solution {
    public int goodNodes(TreeNode root) {
        return countOfGoodNodes(root, root.val);
    }

    private int countOfGoodNodes(TreeNode node, int maxSoFar) {
        int numGoodNodes = 0;

        if (node != null) {
            if (node.val >= maxSoFar) {
                maxSoFar = node.val;
                numGoodNodes++;
            }
            numGoodNodes += countOfGoodNodes(node.left, maxSoFar);
            numGoodNodes += countOfGoodNodes(node.right, maxSoFar);
        }
        return numGoodNodes;
    }
}