// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/editorial/

// Use the property of BST.

// Left subtree of a node N contains nodes whose values are lesser than or equal to node N's value.
// Right subtree of a node N contains nodes whose values are greater than node N's value.
// Both left and right subtrees are also BSTs.

// Start traversing the tree from the root node.
// If both the nodes p and q are in the right subtree, then continue the search with right subtree starting step 1.
// If both the nodes p and q are in the left subtree, then continue the search with left subtree starting step 1.
// If both step 2 and step 3 are not true, this means we have found the node which is common to node p's and q's subtrees.
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
        return null;
    }

    int parentVal = root.val;
    int pVal = p.val;
    int qVal = q.val;

    if (pVal > parentVal && qVal > parentVal) {
        lowestCommonAncestor(root.right, p, q);
    } else if (pVal < parentVal && qVal < parentVal) {
        lowestCommonAncestor(root.left, p, q);
    } else {
        return root;
    }
}


// Time Complexity: O(N), where N is the number of nodes in the BST. In the worst case we might be visiting all the nodes of the BST.