// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
// Time Complexity: O(N), where N is the number of nodes in the tree
class Solution {
    List<List<Integer>> levels = new ArrayList<>();

    private void helper(TreeNode node, int level) {
        if (level >= levels.size()) {
            LinkedList<Integer> newList = new LinkedList<>();
            newList.add(node.val);
            levels.add(newList);
        } else if (level % 2 == 0) {
            levels.get(level).add(node.val); // add node.val to end of linked list at this level
        } else {
            levels.get(level).add(0, node.val); // add node.val to the begin of linked list at this level
        }
        if (node.left != null) {
            helper(node.left, level + 1);
        }
        if (node.right != null) {
            helper(node.right, level + 1);
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return levels;
        }
        helper(root, 0);
        return levels;
    }
}