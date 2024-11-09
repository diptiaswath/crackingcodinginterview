//https://leetcode.com/problems/validate-binary-search-tree/editorial/
class ValidateBST {
    // Uses DFS where each node on left is bounded as: lower bound, upper bound -> (low, root.val)
    // where each node on right is bounded as: lower bound, upper bound -> (high, root.val)

    private boolean validate(TreeNode node, Integer low, Integer high) {
        if (node == null) {
            return true;
        }
        // node val should be between low and high
        if ((low != null && node.val <= low) ||
                (high !=null && node.val >=high)) {
            return false;
        }
        return validate(node.left, low, node.val) &&
                validate(node.right, node.val, high);
    }

    // MAIN FUNCTION
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }









    // Another approach:
    public boolean isValidBSTWithInorder(TreeNode root) {
        prev = null;
        return inorder(root);
    }

    private boolean inorder(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!inorder(root.left)) {
            return false;
        }
        if (prev != null && root.val <= prev) {
            return false;
        }
        prev = root.val;
        return inorder(root.right);
    }
}