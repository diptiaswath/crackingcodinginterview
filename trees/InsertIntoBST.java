// https://leetcode.com/problems/insert-into-a-binary-search-tree/editorial/
class Solution {
    // Time complexity : O(H), where H is a tree height. That results in O(logN) in the average case,
    // and O(N) in the worst case.
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        // insert into the right subtree
        if (val > root.val) root.right = insertIntoBST(root.right, val);
        // insert into the left subtree
        else root.left = insertIntoBST(root.left, val);
        return root;
    }
}