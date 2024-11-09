// https://leetcode.com/problems/delete-node-in-a-bst/editorial/
public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) return null;

    // delete from the right subtree
    if (key > root.val) root.right = deleteNode(root.right, key);
        // delete from the left subtree
    else if (key < root.val) root.left = deleteNode(root.left, key);
        // delete the current node
    else {
        // the node is a leaf
        if (root.left == null && root.right == null) {
            root = null;
        } else if (root.right != null) { // the node is not a leaf and has a right child
            root.val = successor(root);
            root.right = deleteNode(root.right, root.val);
        } else { // // the node is not a leaf, has no right child, and has a left child
            root.val = predecessor(root);
            root.left = deleteNode(root.left, root.val);
        }
    }
    return root;
}

// Find successor of a node in a BST
public int successor(TreeNode root) {
    root = root.right;
    while (root.left != null) {
        root = root.left;
    }
    return root.val;
}

// Find predecessor of a node in a BST
public int predecessor(TreeNode root) {
    root = root.left;
    while (root.right != null) {
        root = root.right;
    }
    return root.val;
}