// Uses recursion: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/editorial/
// Flatten Binary Tree to a singly linked list
class FlattenBinaryTree {

    private TreeNode flattenTree(TreeNode node) {
        if (node == null) {
            return null;
        }

        // if left and right are leaves, return as well
        if (node.left == null && node.right == null) {
            return node;
        }

        // Flatten left subtree recursively and get its leftTail
        TreeNode leftTail = flattenTree(node.left);

        // Flatten right subtree recursively and get its rightTail
        TreeNode rightTail = flattenTree(node.right);

        // If there was a left subtree, we shuffle the connections
        // around so that there is nothing on the left side
        // anymore.
        if (leftTail != null) {
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }

        // We need to return the "rightmost" node after we are
        // done wiring the new connections
        return rightTail == null? leftTail: rightTail;
    }

    public void flatten(TreeNode root) {
        this.flattenTree(root);
    }
}