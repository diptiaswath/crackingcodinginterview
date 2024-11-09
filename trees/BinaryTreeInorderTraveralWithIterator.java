/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// https://leetcode.com/problems/binary-search-tree-iterator/
// Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):
class BSTIterator {
    private int index = -1;
    private List<Integer> nodes;

    public BSTIterator(TreeNode root) {
        this.nodes = new ArrayList<>();
        inOrderTraverse(root);
    }

    private void inOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraverse(node.left);
        nodes.add(node.val);
        inOrderTraverse(node.right);
    }

    public int next() {
        if (hasNext()) {
            return nodes.get(++index);
        }
        return -1;
    }

    public boolean hasNext() {
        return index + 1 < nodes.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */