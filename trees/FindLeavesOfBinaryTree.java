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
// https://leetcode.com/problems/find-leaves-of-binary-tree/
// TIP: Compute height of a given node by traversing tree in a DFS recursively.
// At a given height, store all the nodes at that height into a list
// height(root) = 1 + max(height(root.left), height(root.right))
class Solution {
    List<List<Integer>> solutions = new ArrayList<>();


    private int findHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        int curHeight = 1 + Math.max(leftHeight, rightHeight);

        if (solutions.size() == curHeight) {
            solutions.add(new ArrayList<>());
        }
        solutions.get(curHeight).add(root.val);
        return curHeight;
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        findHeight(root);
        return solutions;
    }
}