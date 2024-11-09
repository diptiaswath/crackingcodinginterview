// https://leetcode.com/problems/binary-tree-level-order-traversal/editorial/
// O(N) : YOU ARE TRAVERSING THE NODES EXACTLY ONCE
// Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
class Solution {
    // PreOrder Traversal
    private List<List<Integer>> levels = new ArrayList<>();

    private void helper(TreeNode node, int level) {
        if (level == levels.size()) {
            levels.add(new ArrayList<>());
        }

        // add node.val to current level
        levels.get(level).add(node.val);

        // pre-order traverse left subtree
        if (node.left != null) {
            helper(node.left, level + 1);
        }
        // pre-order traverse right subtree
        if (node.right != null) {
            helper(node.right, level + 1);
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return levels;
        }
        helper(root, 0);
        return levels;
    }
}