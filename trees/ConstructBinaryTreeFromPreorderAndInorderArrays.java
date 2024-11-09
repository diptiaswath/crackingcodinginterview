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
// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
// Approach: preorder array with a preorderIndex to track the root elements of subtrees
// inorderIndexMap to track index of each element in order array
// see the visual in leetcode editorial - O(N) where N = length of the input arrays
// example inorder = [1, 9, 3, 15, 20, 7] root =3, left subtree = [1, 9], right subtree = [15, 20, 7]
// preorder = [3, 9, 1, 2, 20, 15, 7] root starts with 3, then 9...
// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/editorial/

// Time Complex: O(N) to traverse input arrays
class Solution {
    private int preorderIndex = 0;
    private Map<Integer, Integer> inorderIndexMap = new HashMap<>();

    // MAIN FUNCTION
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // Build a inorderIndexMap where key = inOrder element, value = index of that element
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        // build a Tree from array
        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }
        int rootVal = preorder[preorderIndex++];
        TreeNode node = new TreeNode(rootVal);
        node.left = arrayToTree(preorder, left, inorderIndexMap.get(rootVal) - 1);
        node.right = arrayToTree(preorder, inorderIndexMap.get(rootVal) + 1, right);
        return node;
    }
}