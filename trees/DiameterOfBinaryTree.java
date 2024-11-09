// https://leetcode.com/problems/diameter-of-binary-tree/editorial/
public class DiameterOfBinaryTree {
    private int diameter;

    public int diameterOfBinaryTree(TreeNode<Integer> root) {
       this.diameter = 0;
       longestPath(root);
       return diameter;
    }

    // You will see we are going to address them by
    // 1) applying DFS to recursively find the longest branches starting with the node's left and right children;
    // 2) initializing a global variable diameter to keep track of the longest path and
    // updating it at each node with the sum of the node's left and right branches;
    // 3) returning the length of the longest branch between a node's left and right branches.
    private int longestPath(TreeNode<Integer> node) {
        if (node == null) {
            return 0;
        }
        int lPath = longestPath(node.left);
        int rPath = longestPath(node.right);


        diameter = Math.max(diameter, lPath + rPath);

        // Return longest path, remember to add 1 for the path connecting the node and its parent.
        // DO NOT do anything with returned longest path value
        return Math.max(lPath, rPath) + 1;
    }
}


// TIP: Compute the max depth of binary tree = Math.max(lPath, rPath) + 1.
// Then diamter = Math.max(diameter, lPath + rPath)