// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

// Time Complexity: O(N)

// Start traversing the tree from the root node.
// If the current node itself is one of p or q, we would mark a variable mid as True and continue the search for the
// other node in the left and right branches.
// If either of the left or the right branch returns True, this means one of the two nodes was found below.
// If at any point in the traversal, any two of the three flags left, right or mid become True, this means we have
// found the lowest common ancestor for the nodes p and q.
class LowestCommonAncestor {
    private TreeNode answer;

    private boolean recurseTree(TreeNode current, TreeNode p, TreeNode q) {
        if (current == null) {
            return false;
        }
        int left = recurseTree(current.left, p, q) ? 1: 0;
        int right = recurseTree(current.right, p, q) ? 1: 0;

        int mid = (current == p || current == q) ? 1: 0;

        // If any two of the flags left, right or mid become True
        if (mid + left + right >= 2) {
            this.answer = current;
        }

        // return true if any of (left, right, mid) is set to true
        return (left+right+mid) > 0;
    }

    // Main function
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recurseTree(root, p, q);
        return answer;
    }
}