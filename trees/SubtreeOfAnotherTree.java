// Given two binary trees with their roots, root and subRoot. Return true, if the tree with subroot appears as a subtree of root, having the same node value and structure.

// O(MN)
// Time complexity: O(MN). For every N node in the tree, we check if the tree rooted at node is identical to subRoot.
// This check takes O(M) time, where M is the number of nodes in subRoot. Hence, the overall time complexity is O(MN).


class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        // // Check if the current nodes of root and subRoot are identical OR the same
        if (isSame(root, subRoot)) {
            return true;
        }
        // // Otherwise, recursively check if the left and right subtrees are the same as subRoot
        return (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));

    }

    private boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }
}