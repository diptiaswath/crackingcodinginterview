// https://leetcode.com/problems/binary-tree-right-side-view/
class BinaryTreeRightSide {

    // Approach1 : Using BFS with 2 lists, one for curLevel and another for nextLevel
    // Time complexity: O(N) since one has to visit each node.
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSide = new ArrayList<>();

        // First for curLevel
        List<TreeNode> curLevel = new ArrayList<>();

        if (root != null) {
            curLevel.add(root);
        }

        while (!curLevel.isEmpty()) {
            rightSide.add(curLevel.get(curLevel.size()-1).val);

            // Now to get to nextLevel
            List<TreeNode> nextLevel = new ArrayList<TreeNode>();

            for (TreeNode node: curLevel) {
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            curLevel = nextLevel;
        } // end of while
        return rightSide;
    }

    //////////////// APPROACH WITH DFS //////////////////
    private void preOrderTraverse(TreeNode node, int level, List<Integer> rightSide) {
        if (node == null) {
            return;
        }
        if (level == rightSide.size()) {
            rightSide.add(node.val);
        }

        preOrderTraverse(node.right, level+1, rightSide);
        preOrderTraverse(node.left, level+1, rightSide);
    }

    // Approach2: Use DFS
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSide = new ArrayList<>();
        preOrderTraverse(root, 0, rightSide);
        return rightSide;
    }
}